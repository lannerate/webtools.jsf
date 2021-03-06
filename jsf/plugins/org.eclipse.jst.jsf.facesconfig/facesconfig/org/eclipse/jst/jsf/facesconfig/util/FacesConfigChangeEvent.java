/***************************************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM Corporation - initial API and implementation
 **************************************************************************************************/
package org.eclipse.jst.jsf.facesconfig.util;

/**
 * This class should NOT be referenced or extended by clients.
 * 
 * @author xnjiang
 *
 */
final class FacesConfigChangeEvent implements IFacesConfigChangeEvent {

	private boolean bManagedBeandChanged = true;
	private boolean bNavigationRuleChanged = true;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jst.jsf.facesconfig.IFacesConfigChangeEvent#isManagedBeanChanged()
	 */
	public boolean isManagedBeanChanged() {
		return bManagedBeandChanged;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jst.jsf.facesconfig.IFacesConfigChangeEvent#isNavigationRuleChanged()
	 */
	public boolean isNavigationRuleChanged() {
		return bNavigationRuleChanged;
	}
}
