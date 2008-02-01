/*******************************************************************************
 * Copyright (c) 2007 Oracle Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oracle - initial API and implementation
 *    
 ********************************************************************************/
package org.eclipse.jst.jsf.common.metadata.internal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jst.jsf.common.JSFCommonPlugin;
import org.eclipse.jst.jsf.common.metadata.Model;
import org.eclipse.jst.jsf.common.metadata.query.ITaglibDomainMetaDataModelContext;

/**
 * Singleton instance for each IProject used to manage all standard metdata models for that project.
 *
 * Manager is responsible for loading and caching MetaDataModels.  Models are keyed by URI.
 * 
 * The manager listens for project closing resource events so that the resources can be freed up.
 */
public class MetaDataModelManager implements IResourceChangeListener{
	/**
	 * Key that is used for the IProject instance's session property that
	 * holds a MetaDataModelManager instance.  Each project will have it's own instance of a model manager.
	 */
	public static final QualifiedName KEY_SESSIONPROPERTY =
		new QualifiedName(null, "MetaDataModelManager"); //$NON-NLS-1$ FIX ME	

	private static MetaDataModelManager SHARED_INSTANCE;
	private ModelMap models; 
	private IProject project;
	
	/**
	 * @return instance that is project agnostic.   * may get removed * 
	 */
	public synchronized static MetaDataModelManager getSharedInstance(){
		if (SHARED_INSTANCE == null) {
			SHARED_INSTANCE = new MetaDataModelManager(null);
		}
		return SHARED_INSTANCE;
	}
	
	/**
	 * @param project
	 * @return instance of the model manager for this project.  Shouldn't, but may, return null.
	 */
	public synchronized static MetaDataModelManager getInstance(IProject project){
		MetaDataModelManager repo = null;
		repo = getFromSessionProperty(project);
		if (repo == null) {
			repo = new MetaDataModelManager(project);		
			ResourcesPlugin.getWorkspace().addResourceChangeListener(repo, IResourceChangeEvent.PRE_CLOSE);
		}
		return repo;
	}
	private MetaDataModelManager(IProject project) {
		this.project = project;
		init();
	}
	
	/**
	 * @param project
	 * @return MetaDataModelManager instance for the project
	 */
	protected static MetaDataModelManager getFromSessionProperty(IProject project) {
		MetaDataModelManager repo = null;
		try {
			Object obj = project.getSessionProperty(KEY_SESSIONPROPERTY);
			if (obj instanceof MetaDataModelManager) {
				repo = (MetaDataModelManager)obj;
			}
		} catch(CoreException ce) {
			JSFCommonPlugin.log(IStatus.ERROR, "Internal Error: Unable to recover MetaDataModelManager for: "+project.getName(), ce); //$NON-NLS-1$
		}
		return repo;
	}

	/**
	 * Sets this MetaDataModelManager instance as a session property of its
	 * IProject instance.
	 */
	protected void setAsSessionProperty() {
		if (project != null) {//&& project.isAccessible()) {
			try {
				project.setSessionProperty(KEY_SESSIONPROPERTY, this);
			} catch(CoreException ce) {
				JSFCommonPlugin.log(IStatus.ERROR, "Internal Error: Unable to store MetaDataModelManager for: "+project.getName(), ce); //$NON-NLS-1$		}
			}
		}
	}
	
	/**
	 * Releases a project's MetaDataModelManager instance by removing from project session property
	 * @param aProject
	 */
	protected void removeAsSessionProperty(IProject aProject){
		try {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			aProject.setSessionProperty(KEY_SESSIONPROPERTY, null);
		} catch (CoreException e) {
            JSFCommonPlugin.log(e, "Error removing session property"); //$NON-NLS-1$
		}
	}
	
	private synchronized void init() {
		models = new ModelMap();	
		setAsSessionProperty();
	}
	
	
	/**
	 * Will locate the cached MetaDataModel.   Sets the model context in the model.
	 * @param modelContext
	 * @return the MetaDataModel for the given ITaglibDomainMetaDataModelContext
	 */
	public synchronized MetaDataModel getModel(final ITaglibDomainMetaDataModelContext modelContext){
		ModelKeyDescriptor modelKeyDescriptor = StandardModelFactory.getInstance().createModelKeyDescriptor(modelContext);
		MetaDataModel model = models.get(modelKeyDescriptor);
		if (model == null || project == null){
//			long in = System.currentTimeMillis();					
			model = loadMetadata(modelKeyDescriptor);			
//			System.out.println("Time to load "+modelContext.getURI()+": "+String.valueOf(System.currentTimeMillis() - in));
		}
		else if (model.needsRefresh()){
			try {
				model.reload();
			} catch (ModelNotSetException e) {
				//simply load it - should not get here
				model = loadMetadata(modelKeyDescriptor);
			}
		}
		if (model != null && model.getRoot() != null)
			((Model)model.getRoot()).setCurrentModelContext(modelKeyDescriptor);
		
		return model;
	}
	
	private void addModel(MetaDataModel model) {
		
		if (model != null)
			models.put(model.getModelKey(), model);		
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE){
			//a project is closing - release and cleanup
			final IProject aProject = (IProject)event.getResource();
			if (aProject == this.project){
				SafeRunnable.run(new ISafeRunnable(){

					public void handleException(Throwable exception) {
						// FIXME: what to do here?
						
					}

					public void run() throws Exception {
						for (Iterator it=models.getModels().iterator();it.hasNext();){
							MetaDataModel model = (MetaDataModel)it.next();
//							System.out.println("kill mmModel: "+model.toString());
							models.remove(model);
							model.cleanup();					
						}
						removeAsSessionProperty(project);
					}					
				});			
			}
		}
		
	}
	
	private synchronized MetaDataModel loadMetadata(ModelKeyDescriptor modelKeyDescriptor){
		IDomainLoadingStrategy strategy = DomainLoadingStrategyRegistry.getInstance().getLoadingStrategy(modelKeyDescriptor.getDomain());;
		if (strategy == null){
			JSFCommonPlugin.log(IStatus.ERROR, "Internal Error: Unable to locate metadata loading strategy for: "+modelKeyDescriptor.toString()); //$NON-NLS-1$
			return null;
		}
		MetaDataModel model = StandardModelFactory.getInstance().createModel(modelKeyDescriptor, strategy);//new MetaDataModel(modelKey, strategy);
		model.load();
		addModel(model);

		return model;
	}

	/**
	 * Map of models keyed by ModelKeyDescriptor (.toString())
	 *
	 */
	private class ModelMap{
		private HashMap /*<String, MetaDataModel>*/ map;
		
		ModelMap(){
			map = new HashMap/*<String, MetaDataModel>*/();
		}
		
		/**
		 * @param modelKeyDescriptor
		 * @param model adds model to the map using the given key descriptor
		 */
		public void put(ModelKeyDescriptor modelKeyDescriptor, MetaDataModel model){
			String key = modelKeyDescriptor.toString();
			map.put(key, model);
		}
		
		/**
		 * @param modelKeyDescriptor
		 * @return MetaDataModel for this ModelKeyDescriptor.  May return null.
		 */
		public synchronized MetaDataModel get(ModelKeyDescriptor modelKeyDescriptor){
			String key = modelKeyDescriptor.toString();
			return (MetaDataModel)map.get(key);
		}
		
		/**
		 * @param model from the map
		 */
		public void remove(MetaDataModel model){
			map.remove(model.getModelKey().toString());
		}
		/**
		 * @return models in this map as a Set
		 */
		public Set getModels(){
			Set ret = new HashSet();
			for (Iterator it=map.entrySet().iterator();it.hasNext();){
				Map.Entry entry = (Map.Entry)it.next();
				ret.add(entry.getValue());
			}
			return ret;
		}
	}


}
