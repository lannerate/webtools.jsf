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
package org.eclipse.jst.jsf.facesconfig.internal.translator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jst.jsf.facesconfig.emf.FacesConfigPackage;
import org.eclipse.wst.common.internal.emf.resource.Translator;

/**
 * @author xnjiang
 *
 */
public class ExceptionHandlerFactoryTranslator extends Translator {
	/**
	 * @param domNameAndPath
	 * @param aFeature
	 */
	public ExceptionHandlerFactoryTranslator(String domNameAndPath, EStructuralFeature aFeature) {
		super(domNameAndPath, aFeature, END_TAG_NO_INDENT);
	}

	/*  (non-Javadoc)
	 * @see org.eclipse.wst.common.internal.emf.resource.Translator#getChildren()
	 */
	public Translator[] getChildren() {
		
		FacesConfigPackage facesPackage = FacesConfigPackage.eINSTANCE;
		return new Translator[] {
			new Translator(TEXT_ATTRIBUTE_VALUE, facesPackage.getExceptionHandlerFactoryType_TextContent()),
			new Translator("id", facesPackage.getExceptionHandlerFactoryType_Id(), DOM_ATTRIBUTE) //$NON-NLS-1$
		};
	}
}
