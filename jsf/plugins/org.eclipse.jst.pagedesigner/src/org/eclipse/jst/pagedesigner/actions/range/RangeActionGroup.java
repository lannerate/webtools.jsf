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
package org.eclipse.jst.pagedesigner.actions.range;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jst.pagedesigner.IHTMLConstants;
import org.eclipse.jst.pagedesigner.PDPlugin;
import org.eclipse.jst.pagedesigner.actions.link.MakeLinkAction;
import org.eclipse.jst.pagedesigner.editors.PageDesignerActionConstants;
import org.eclipse.jst.pagedesigner.editors.actions.DesignActionBarFactory;
import org.eclipse.jst.pagedesigner.viewer.DesignRange;
import org.eclipse.jst.pagedesigner.viewer.IHTMLGraphicalViewer;
import org.eclipse.ui.actions.ActionGroup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author mengbo
 * @version 1.5
 */
public class RangeActionGroup extends ActionGroup {
	public static Action action = new Action() {
	};

	/**
	 * 
	 */
	public RangeActionGroup() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void fillContextMenu(IMenuManager menu) {
		DesignRange selection = fixUpSelection(getContext().getSelection());
		if (selection == null) {
			return;
		}
		if (getContext().getInput() instanceof IHTMLGraphicalViewer) {
			addParagraphFormatMenu(menu, selection,
					(IHTMLGraphicalViewer) getContext().getInput());
			addHorizontalAlignMenu(menu, selection,
					(IHTMLGraphicalViewer) getContext().getInput());
			addTextStyleMenu(menu, (IHTMLGraphicalViewer) getContext()
					.getInput());
		}
		addListModeMenu(menu, selection);

		addTextFontMenu(menu, selection);

		addLinkMenu(menu, selection);
	}

	/**
	 * @param selection
	 * @return
	 */
	private DesignRange fixUpSelection(ISelection selection) {
		if (selection instanceof DesignRange) {
			return (DesignRange) selection;
		} else {
			return null;
		}
	}

	private void addLinkMenu(IMenuManager menu, final DesignRange selection) {
		Action action = new MakeLinkAction(selection);
		menu.appendToGroup(PageDesignerActionConstants.GROUP_STYLE, action);
	}

	private void addTextStyleMenu(IMenuManager menu,
			final IHTMLGraphicalViewer viewer) {
		final IMenuManager submenu = new MenuManager(PDPlugin
				.getResourceString("ActionGroup.Submenu.TextStyle"));//$NON-NLS-1$
		submenu.add(action);

		submenu.setRemoveAllWhenShown(true);
		submenu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DesignerToolBarAction action = null;
				action = DesignActionBarFactory.getInstance().getStyleAction(
						IHTMLConstants.TAG_U);
				action.setViewer(viewer);
				submenu.add(action);

				action = DesignActionBarFactory.getInstance().getStyleAction(
						IHTMLConstants.TAG_B);
				action.setViewer(viewer);
				submenu.add(action);

				action = DesignActionBarFactory.getInstance().getStyleAction(
						IHTMLConstants.TAG_I);
				action.setViewer(viewer);
				submenu.add(action);

				action = DesignActionBarFactory.getInstance().getStyleAction(
						IHTMLConstants.TAG_SMALL);
				action.setViewer(viewer);
				submenu.add(action);

				action = DesignActionBarFactory.getInstance().getStyleAction(
						IHTMLConstants.TAG_BIG);
				action.setViewer(viewer);
				submenu.add(action);

			}
		});
		menu.appendToGroup(PageDesignerActionConstants.GROUP_STYLE, submenu);
	}

	/**
	 * @param menu
	 * @param selection
	 */
	private void addTextFontMenu(IMenuManager menu, DesignRange selection) {

	}

	/**
	 * @param menu
	 * @param selection
	 */
	private void addHorizontalAlignMenu(IMenuManager menu,
			final DesignRange selection, final IHTMLGraphicalViewer viewer) {
		// we have to initialize align nodes here for some refresh problem
		Element[] alignNodes = new Element[4];
		final String[] alignValues = new String[] { "left", "center", "right",
				"justify" };
		Document document = viewer.getModel().getDocument();
		for (int i = 0; i < 4; i++) {
			Element node = document.createElement(IHTMLConstants.TAG_P);
			node.setAttribute(IHTMLConstants.ATTR_ALIGN, alignValues[i]);
			alignNodes[i] = node;
		}
		AlignSupport.setAlignNodes(alignNodes);

		final IMenuManager submenu = new MenuManager(PDPlugin
				.getResourceString("ActionGroup.Submenu.Align"));//$NON-NLS-1$
		submenu.add(action);
		submenu.setRemoveAllWhenShown(true);
		submenu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				AlignSupport.createAlignActions(submenu, viewer);
			}
		});
		menu.appendToGroup(PageDesignerActionConstants.GROUP_STYLE, submenu);

	}

	/**
	 * @param menu
	 * @param selection
	 */
	private void addListModeMenu(IMenuManager menu, DesignRange selection) {
	}

	/**
	 * @param menu
	 * @param selection
	 */
	private void addParagraphFormatMenu(IMenuManager menu,
			final DesignRange selection, final IHTMLGraphicalViewer viewer) {
		final IMenuManager submenu = new MenuManager(PDPlugin
				.getResourceString("ActionGroup.Submenu.ParagraphFormat"));//$NON-NLS-1$
		submenu.add(action);
		// Add the submenu.
		final int mode = ParagraphSupport.getCurrentParagraphMode(selection);

		submenu.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				submenu.removeAll();
				ParagraphSupport.createParagraphActions(submenu, selection,
						mode, viewer);
			}
		});
		menu.appendToGroup(PageDesignerActionConstants.GROUP_STYLE, submenu);
	}
}
