/*******************************************************************************
 * Copyright (c) 2005 Oracle Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ian Trimble - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.jst.pagedesigner.dtmanager.converter.operations.internal;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jst.pagedesigner.dtmanager.converter.operations.AbstractTransformOperation;
import org.w3c.dom.Element;

/**
 * ITransformOperation implementation that executes child ITransformOperation
 * instances if the XPath expression evaluated against the source Element
 * instance returns a "false" result.
 * 
 * <br><b>Note:</b> requires ITransformOperation.setTagConverterContext(...) to
 * have been called to provide a valid ITagConverterContext instance prior to
 * a call to the transform(...) method.
 * 
 * @author Ian Trimble - Oracle
 */
public class IfNotOperation extends AbstractTransformOperation {

	private String xPathExpression;


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jst.pagedesigner.dtmanager.converter.operations.internal.provisional.AbstractTransformOperation#transform(org.w3c.dom.Element, org.w3c.dom.Element)
	 */
	public Element transform(Element srcElement, Element curElement) {
		if (getParameters().length < 1) {
			getLog().error("Warning.TransformOperationFactory.TooFewParameters", getTransformOperationID()); //$NON-NLS-1$
			return null;
		}
		
		xPathExpression = getParameters()[0];
		Assert.isNotNull(xPathExpression);
		
		Element retElement = curElement;
		if (srcElement != null) {
			XPath xPath = XPathFactory.newInstance().newXPath();
			try {
				Object resultObject = xPath.evaluate(xPathExpression, srcElement, XPathConstants.BOOLEAN);
				if (!((Boolean)resultObject).booleanValue()) {
					retElement = executeChildOperations(srcElement, retElement);
				}
			} catch(XPathExpressionException xee) {
				//could not evaluate - return curElement
			}
		}
		return retElement;
	}

}
