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
package org.eclipse.jst.pagedesigner.css2.style;

/**
 * @author mengbo
 * @version 1.5
 */
public interface ITagEditInfo {
	public boolean isWidget();

	public boolean needBorderDecorator();

	public boolean needTableDecorator();

	/**
	 * for some element in design mode we want to them to have a default min
	 * size.
	 * 
	 * @return positive value means an expected min size.
	 */
	public int getMinWidth();

	public int getMinHeight();
}
