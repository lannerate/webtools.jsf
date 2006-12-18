/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gerry Kessler/Oracle - initial API and implementation
 *    
 ********************************************************************************/
package org.eclipse.jst.jsf.taglibprocessing.internal.provisional.attributevalues;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract meta-data processing type representing an expression binding attribute value runtime type
 * @author Gerry Kessler - Oracle
 */
public abstract class ExpressionBindingType extends BindingType  {
	/**
	 * Valid values is any fully qualified Java type or primitive.  
	 * Assign a value for each parameter in order
	 */
	public static final String RUNTIME_PARAMS_TYPES = "runtime-param-types"; //$NON-NLS-1$
	/**
	 * Valid values is any fully qualified Java type or primitive.  
	 */
	public static final String RUNTIME_RETURN_TYPE = "runtime-return-type"; //$NON-NLS-1$
	/**
	 * Value should be set true or false.   If not specified, the default inmplementation assumes false. 
	 */
	public static final String RUNTIME_SETTER_REQUIRED = "runtime-type-setter-required"; //$NON-NLS-1$
	private List validationMessages;
	

	protected String getReturnType() {
		return getCMAttributePropertyValue(RUNTIME_RETURN_TYPE);		
	}

	protected String[] getParams() {
		List params = getCMAttributePropertyValues(RUNTIME_PARAMS_TYPES);
		
		return (String[])params.toArray(new String[0]);
	}

	public List getValidationMessages() {
		if (validationMessages == null){
			validationMessages = new ArrayList();
		}
		return validationMessages;
	}

	
}