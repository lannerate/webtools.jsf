/*******************************************************************************
 * Copyright (c) 2006 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.pagedesigner.properties.celleditors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.window.Window;
import org.eclipse.jst.pagedesigner.common.dialogs.CommonResourceDialog;
import org.eclipse.jst.pagedesigner.common.utils.PathUtil;
import org.eclipse.jst.pagedesigner.common.utils.WebrootUtil;
import org.eclipse.jst.pagedesigner.utils.WebAppUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author mengbo
 */
public class ResourceDialogCellEditor extends EditableDialogCellEditor {
	private IProject _project;

	private String[] _suffixs;

	private String _resourceDescription;

	private IFile _referredFile;

	private boolean _isWebPath = false;

	private boolean _needTransformJSPURL = true;

	private String _separator = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see DialogCellEditor#DialogCellEditor()
	 */
	public ResourceDialogCellEditor() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DialogCellEditor#DialogCellEditor(Composite parent)
	 */
	public ResourceDialogCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DialogCellEditor#DialogCellEditor(Composite parent, int style)
	 */
	public ResourceDialogCellEditor(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		Shell shell = cellEditorWindow.getShell();
		int style = "".equals(_separator) ? SWT.NONE : SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL;
		CommonResourceDialog dialog = new CommonResourceDialog(shell, _project,
				style);
		dialog.setTitle(ResourceBoundle.getString("FileCellEditor.Title"));
		dialog.setSuffixs(_suffixs);
		dialog.setResourceDescription(_resourceDescription);
		if (dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < result.length; i++) {
				IPath path = ((IFile) result[i]).getLocation();

				IPath referredPath = null;
				if (_referredFile != null) {
					referredPath = _referredFile.getLocation();
				} else {
					referredPath = _project.getLocation();
				}

				String newValue = null;
				if (this._isWebPath) {
					IFile selectedFile = ((IFile) result[i]);
					newValue = WebrootUtil.getWebPath(selectedFile
							.getFullPath());
				} else {
					newValue = PathUtil.convertToRelativePath(path.toString(),
							referredPath.toString());
				}
				if (this._needTransformJSPURL) {
					newValue = WebAppUtil.transformJSPURL(newValue,
							this._referredFile);
				}
				buffer.append(newValue);
				buffer.append(_separator);
			}
			if (buffer.length() > 0) {
				return buffer.substring(0, buffer.length()
						- _separator.length());
			}
		}
		return null;
	}

	/**
	 * @param project
	 */
	public void setProject(IProject project) {
		this._project = project;
	}

	/**
	 * @return Returns the project.
	 */
	public IProject getProject() {
		return _project;
	}

	/**
	 * @return Returns the referredFile.
	 */
	public IFile getReferredFile() {
		return _referredFile;
	}

	/**
	 * @param referredFile
	 *            The referredFile to set.
	 */
	public void setReferredFile(IFile referredFile) {
		this._referredFile = referredFile;
	}

	/**
	 * @return Returns the resourceDescription.
	 */
	public String getResourceDescription() {
		return _resourceDescription;
	}

	/**
	 * @param resourceDescription
	 *            The resourceDescription to set.
	 */
	public void setResourceDescription(String resourceDescription) {
		this._resourceDescription = resourceDescription;
	}

	/**
	 * @return Returns the suffixs.
	 */
	public String[] getSuffixs() {
		return _suffixs;
	}

	/**
	 * @param suffixs
	 *            The suffixs to set.
	 */
	public void setSuffixs(String[] suffixs) {
		this._suffixs = suffixs;
	}

	/**
	 * set some special path to web path instead of relative path
	 * 
	 * @param isWebPath
	 */
	public void setWebPath(boolean isWebPath) {
		this._isWebPath = isWebPath;
	}

	public void setTransformJSPURL(boolean needTransform) {
		this._needTransformJSPURL = needTransform;
	}

	public String getSeparator() {
		return _separator;
	}

	public void setSeparator(String separator) {
		this._separator = separator;
	}
}