/*******************************************************************************
 * Copyright (c) 2008 Oracle Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oracle - initial API and implementation
 *    
 ********************************************************************************/
package org.eclipse.jst.pagedesigner.editors.palette;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jst.jsf.common.metadata.Entity;
import org.eclipse.jst.jsf.common.metadata.Model;
import org.eclipse.jst.jsf.common.metadata.Trait;
import org.eclipse.jst.jsf.common.metadata.internal.IImageDescriptorProvider;
import org.eclipse.jst.jsf.common.metadata.internal.IMetaDataDomainContext;
import org.eclipse.jst.jsf.common.metadata.internal.IMetaDataSourceModelProvider;
import org.eclipse.jst.jsf.common.metadata.internal.TraitValueHelper;
import org.eclipse.jst.jsf.common.metadata.query.internal.MetaDataQueryContextFactory;
import org.eclipse.jst.jsf.common.metadata.query.internal.MetaDataQueryFactory;
import org.eclipse.jst.jsf.common.metadata.query.internal.taglib.ITaglibDomainMetaDataQuery;
import org.eclipse.jst.jsf.common.ui.JSFUICommonPlugin;
import org.eclipse.jst.jsf.common.ui.internal.utils.JSFSharedImages;
import org.eclipse.jst.jsf.tagdisplay.internal.paletteinfos.PaletteInfo;
import org.eclipse.jst.jsf.tagdisplay.internal.paletteinfos.PaletteInfos;
import org.eclipse.jst.pagedesigner.PDPlugin;
import org.eclipse.swt.graphics.Image;

/**
 * Locates and creates Images for tags using the common metadata framework.
 * 
 * Images are cached in the PDPlugin's ImageRegistry.  
 * 
 * Some code is being duplicated in palette helper.   PaletteHelper should be re-factored to use this code
 * 
 */
public class TagImageManager {
	
	private static final String PALETTE_DEFAULT_IMAGE_FILE = "palette/GENERIC/large/PD_Palette_Default.gif"; //$NON-NLS-1$

	private static TagImageManager INSTANCE = null;
	
	private final static ImageDescriptor DEFAULT_SMALL_ICON = JSFUICommonPlugin
	.getDefault().getImageDescriptor(
		JSFSharedImages.DEFAULT_PALETTE_TAG_IMG);

	private final static ImageDescriptor DEFAULT_LARGE_ICON = PDPlugin
		.getDefault().getImageDescriptor(
				PALETTE_DEFAULT_IMAGE_FILE);

	private static final String TRAIT_ICON_SMALL = "small-icon"; //$NON-NLS-1$

	private static final String TRAIT_ICON_LARGE = "large-icon"; //$NON-NLS-1$
	
	/**
	 * @return singleton instance 
	 */
	public synchronized static TagImageManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TagImageManager();
		}
		return INSTANCE;
	}	
	
	/**
	 * Returns small image using metadata and may be null.  Caller should NOT dispose the image, but should call TagImageManager's dispose(image)
	 * @param file
	 * @param nsUri
	 * @param tagName
	 * @return small image using metadata.  May be null.
	 */
	public Image getSmallIconImage(IFile file, String nsUri, String tagName) {
		final IMetaDataDomainContext context = MetaDataQueryContextFactory.getInstance().createTaglibDomainModelContext(file);			
		return getImage(context, nsUri, tagName, true);
	}
	
	/**
	 * Returns small image using metadata and may be null.  Caller should NOT dispose the image, but should call TagImageManager's dispose(image)
	 * @param project 
	 * @param nsUri
	 * @param tagName
	 * @return small image using metadata.  May be null.
	 * @deprecated - use file rather than project
	 */
	public Image getSmallIconImage(IProject project, String nsUri, String tagName) {
		final IMetaDataDomainContext context = MetaDataQueryContextFactory.getInstance().createTaglibDomainModelContext(project);			
		return getImage(context, nsUri, tagName, true);
	}

	/**
	 * @param file
	 * @param nsUri
	 * @param tagName
	 * @return large image using metadata.  May be null.
	 */
	public Image getLargeIconImage(IFile file, String nsUri, String tagName) {
		final IMetaDataDomainContext context = MetaDataQueryContextFactory.getInstance().createTaglibDomainModelContext(file);
		return getImage(context, nsUri, tagName, false);
	}
	
	/**
	 * @param project
	 * @param nsUri
	 * @param tagName
	 * @return large image using metadata.  May be null.
	 * @deprecated - use file rather than project
	 */
	public Image getLargeIconImage(IProject project, String nsUri, String tagName) {
		final IMetaDataDomainContext context = MetaDataQueryContextFactory.getInstance().createTaglibDomainModelContext(project);
		return getImage(context, nsUri, tagName, false);
	}
	
	private Image getImage(final IMetaDataDomainContext context, final String nsUri, final String tagName, boolean getSmallImage) {
		Image image = null;
		final ITaglibDomainMetaDataQuery query = MetaDataQueryFactory.getInstance().createQuery(context);
		Model model = getModel(query, nsUri);
		if (model != null){
			ImageDescriptor imgDesc = getIconImageDescriptor(query, model, tagName, getSmallImage);
			image = getOrCreateImage(imgDesc);
		}
		
		return image;
	}
	
	/**
	 * Gets, and creates if necessary, a shared image.
	 * @param imageDescriptor
	 * @return Image from shared cache
	 */
	public static Image getOrCreateImage(ImageDescriptor imageDescriptor) {
		Image image = null;
		if (imageDescriptor != null){
			image = PDPlugin.getDefault().getImageRegistry().get(imageDescriptor.toString());
			if (image == null ){
				image = imageDescriptor.createImage();
				PDPlugin.getDefault().getImageRegistry().put(imageDescriptor.toString(), image);
			} else if (image.isDisposed()){ //should not occur, but handling just in case				
				PDPlugin.getDefault().getImageRegistry().remove(imageDescriptor.toString());
				image = imageDescriptor.createImage();
				PDPlugin.getDefault().getImageRegistry().put(imageDescriptor.toString(), image);
			}
		}
		return image;
	}
	
	private Model getModel(ITaglibDomainMetaDataQuery query, String nsUri) {
		return query.findTagLibraryModel(nsUri);		
	}

	
	private ImageDescriptor getIconImageDescriptor(ITaglibDomainMetaDataQuery query, Model model, String tagName, boolean small) {		
		ImageDescriptor icon = null;
		
		//use palette infos if available
		Trait trait = query.findTrait(model, "paletteInfos"); //$NON-NLS-1$
		if (trait != null){
			PaletteInfos tags = (PaletteInfos)trait.getValue();
			for (Iterator it=tags.getInfos().iterator();it.hasNext();){
				PaletteInfo tag = (PaletteInfo)it.next();
				if (tag.getId().equalsIgnoreCase(tagName)){					
					IMetaDataSourceModelProvider sourceProvider = ((Trait)tag.eContainer().eContainer()).getSourceModelProvider();
					if (small)
						icon = getImageDescriptorFromString(sourceProvider, tag.getSmallIcon(), DEFAULT_SMALL_ICON);
					else
						icon = getImageDescriptorFromString(sourceProvider, tag.getLargeIcon(), DEFAULT_LARGE_ICON);
					
					break;
				}
			}	
		}
		if (icon == null) {
			for (Iterator it=model.getChildEntities().iterator();it.hasNext();){ 
				Entity tagAsEntity = (Entity)it.next();
				if (tagAsEntity.getId().equalsIgnoreCase(tagName)){										
					if (small)
						icon = getImageDescriptorFromTagTraitValueAsString(query, tagAsEntity, TRAIT_ICON_SMALL, DEFAULT_SMALL_ICON);
					else
						icon = getImageDescriptorFromTagTraitValueAsString(query, tagAsEntity, TRAIT_ICON_LARGE, DEFAULT_LARGE_ICON);	
					
					break;
				}				
			}
			
		}

		return icon;
	}
		
	private ImageDescriptor getImageDescriptorFromString(IMetaDataSourceModelProvider sourceModelProvider,  String imgDesc, ImageDescriptor defaultValue){
		ImageDescriptor image = defaultValue;
		IImageDescriptorProvider imageProvider = (IImageDescriptorProvider)sourceModelProvider.getAdapter(IImageDescriptorProvider.class);			
		if (imageProvider != null){
			image = imageProvider.getImageDescriptor(imgDesc);
		}
		return image;
	}
	
	private ImageDescriptor getImageDescriptorFromTagTraitValueAsString(ITaglibDomainMetaDataQuery query, Entity entity, String key, ImageDescriptor defaultValue){
		Trait t = query.findTrait(entity, key);
		if (t != null){
			String imgDesc = TraitValueHelper.getValueAsString(t);
			return getImageDescriptorFromString(t.getSourceModelProvider(), imgDesc, defaultValue);
		}
		return defaultValue;
	}

}
