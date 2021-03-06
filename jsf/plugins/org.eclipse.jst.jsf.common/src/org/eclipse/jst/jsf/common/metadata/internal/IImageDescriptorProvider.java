/*******************************************************************************
 * Copyright (c) 2001, 2007 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.jsf.common.metadata.internal;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Provides image descriptors relative to the plugin that provided the image metadata
 *
 */
public interface IImageDescriptorProvider {
	/**
	 * @param imagePath
	 * @return ImageDescriptor - implementers should eat exceptions and return null whenever imageDescriptor cannot be returned
	 */
	public ImageDescriptor getImageDescriptor(String imagePath);
}
