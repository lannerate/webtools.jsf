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
package org.eclipse.jst.pagedesigner.editors.pagedesigner;

import java.text.MessageFormat;

import org.eclipse.jst.pagedesigner.PDPlugin;
import org.eclipse.jst.pagedesigner.common.logging.Logger;

/**
 * @A tool class for message format
 */
public class MessageFormater {
	private static Logger _log = PDPlugin.getLogger(MessageFormater.class);

	/**
	 * *
	 * 
	 * @param message:
	 *            the parts for filling is {number}
	 * @param o1
	 * @return
	 */
	public static String format(String message, Object o1) {
		try {
			Object[] args = new Object[] { o1 };
			MessageFormat formatter = new MessageFormat(message);
			return formatter.format(args);
		} catch (Exception e) {
			_log.error("Log.Error.MessageFormater.Format0", e); //$NON-NLS-1$
			return "";
		}
	}

	public static String format(String message, Object o1, Object o2) {
		try {
			Object[] args = new Object[] { o1, o2 };
			MessageFormat formatter = new MessageFormat(message);
			return formatter.format(args);
		} catch (Exception e) {
			_log.error("Log.Error.MessageFormater.Format0", e);
			return "";
		}
	}

	public static String format(String message, Object o1, Object o2, Object o3) {
		try {
			Object[] args = new Object[] { o1, o2, o3 };
			MessageFormat formatter = new MessageFormat(message);
			return formatter.format(args);
		} catch (Exception e) {
			_log.error("Log.Error.MessageFormater.Format0", e);
			return "";
		}
	}

	public static String format(String message, Object o[]) {
		try {
			MessageFormat formater = new MessageFormat(message);
			return formater.format(o);
		} catch (Exception e) {
			_log.error("Log.Error.MessageFormater.Format0", e);
			return "";
		}
	}
}
