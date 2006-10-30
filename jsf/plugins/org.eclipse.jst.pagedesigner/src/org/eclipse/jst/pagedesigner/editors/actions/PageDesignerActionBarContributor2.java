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
package org.eclipse.jst.pagedesigner.editors.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jst.pagedesigner.IJMTConstants;
import org.eclipse.jst.pagedesigner.actions.container.ContainerActionGroup;
import org.eclipse.jst.pagedesigner.actions.menuextension.CustomedContextMenuActionGroup;
import org.eclipse.jst.pagedesigner.actions.range.RangeActionGroup;
import org.eclipse.jst.pagedesigner.actions.single.SingleElementActionGroup;
import org.eclipse.jst.pagedesigner.editors.HTMLEditor;
import org.eclipse.jst.pagedesigner.editors.SimpleGraphicalEditor;
import org.eclipse.jst.pagedesigner.ui.common.sash.NestedEditorActionBarContributor;
import org.eclipse.jst.pagedesigner.viewer.IHTMLGraphicalViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.sse.ui.internal.ExtendedEditorActionBuilder;
import org.eclipse.wst.sse.ui.internal.IExtendedContributor;
import org.eclipse.wst.sse.ui.internal.ISourceViewerActionBarContributor;

/**
 * This is the actionbar contributor for HTML Editor. As HTMLEditor is
 * multipaged, so this contributor will also handle on which page currently is
 * activated.
 * 
 * @author mengbo
 */
public class PageDesignerActionBarContributor2 extends
		NestedEditorActionBarContributor implements IExtendedContributor {

	protected DesignPageActionContributor _designViewerActionBarContributor = null;

	protected ISourceViewerActionBarContributor _sourceViewerActionContributor = null;

	protected HTMLEditor _htmlEditor = null;

	// EditorExtension
	private static final String EDITOR_ID = IJMTConstants.EDITORID_HTML;

	private IExtendedContributor _extendedContributor;

	DesignerStyleActionGroup _group = new DesignerStyleActionGroup();

	private IHTMLGraphicalViewer _viewer = null;

	private IStructuredModel _model = null;

	public static Action action = new Action() {
	};

	public PageDesignerActionBarContributor2() {
		super();

		_sourceViewerActionContributor = new SourcePageActionContributor();
		_designViewerActionBarContributor = new DesignPageActionContributor();

		// Read action extensions.
		ExtendedEditorActionBuilder builder = new ExtendedEditorActionBuilder();
		_extendedContributor = builder.readActionExtensions(EDITOR_ID);
	}

	public void init(IActionBars actionBars) {
		super.init(actionBars);

		if (actionBars != null) {
			initCommonActionBarContributor(actionBars);
			initDesignViewerActionBarContributor(actionBars);
			initSourceViewerActionContributor(actionBars);
		}
	}

	/**
	 * @param actionBars
	 */
	private void initCommonActionBarContributor(IActionBars actionBars) {
		_group.fillActionBars(actionBars);
	}

	protected void initDesignViewerActionBarContributor(IActionBars actionBars) {
		if (_designViewerActionBarContributor != null)
			_designViewerActionBarContributor.init(actionBars, getPage());
	}

	protected void initSourceViewerActionContributor(IActionBars actionBars) {
		if (_sourceViewerActionContributor != null)
			_sourceViewerActionContributor.init(actionBars, getPage());
	}

	public void dispose() {
		super.dispose();
		if (_designViewerActionBarContributor != null) {
			_designViewerActionBarContributor.dispose();
		}
		if (_sourceViewerActionContributor != null) {
			_sourceViewerActionContributor.dispose();
		}
		if (_extendedContributor != null) {
			_extendedContributor.dispose();
		}
		if (_group != null) {
			_group.dispose();
		}
	}

	/**
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(IMenuManager)
	 */
	public final void contributeToMenu(IMenuManager menu) {
		super.contributeToMenu(menu);
		addToMenu(menu);
		if (_extendedContributor != null)
			_extendedContributor.contributeToMenu(menu);
	}

	protected void addToMenu(IMenuManager menu) {
		// IMenuManager menuMgr = new MenuManager(PD_EDITOR_MENU_LABEL,
		// IJMTConstants.PD_EDITOR_MENU_ID);
		// menu.insertBefore(IWorkbenchActionConstants.M_NAVIGATE, menuMgr);
		//
		// menuMgr.add(action);
		// menuMgr.setRemoveAllWhenShown(true);
		//
		// menuMgr.addMenuListener(new IMenuListener()
		// {
		// public void menuAboutToShow(IMenuManager menuMgr)
		// {
		// PageDesignerActionConstants.addStandardActionGroups(menuMgr);
		// RelatedViewActionGroup viewMenu = new RelatedViewActionGroup();
		// viewMenu.fillContextMenu(menuMgr);
		// updateEditorMenu(menuMgr);
		// }
		// });
	}

	/**
	 * @see IExtendedContributor#contributeToPopupMenu(IMenuManager)
	 */
	public final void contributeToPopupMenu(IMenuManager menu) {
		addToPopupMenu(menu);
		if (_extendedContributor != null)
			_extendedContributor.contributeToPopupMenu(menu);
	}

	protected void addToPopupMenu(IMenuManager menu) {
	}

	/**
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToToolBar(IToolBarManager)
	 */
	public final void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		addToToolBar(toolBarManager);
		if (_extendedContributor != null)
			_extendedContributor.contributeToToolBar(toolBarManager);
	}

	protected void addToToolBar(IToolBarManager toolBarManager) {
	}

	/**
	 * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToStatusLine(IStatusLineManager)
	 */
	public final void contributeToStatusLine(IStatusLineManager manager) {
		super.contributeToStatusLine(manager);
		addToStatusLine(manager);
		if (_extendedContributor != null)
			_extendedContributor.contributeToStatusLine(manager);
	}

	protected void addToStatusLine(IStatusLineManager manager) {
	}

	/**
	 * @see IExtendedContributor#updateToolbarActions()
	 */
	public void updateToolbarActions() {
		if (_extendedContributor != null) {
			_extendedContributor.updateToolbarActions();
		}
		_group.setHTMLEditor(_htmlEditor);
	}

	public void setActiveEditor(IEditorPart targetEditor) {
		if (targetEditor instanceof HTMLEditor) {
			_htmlEditor = (HTMLEditor) targetEditor;
			StructuredTextEditor textEditor = _htmlEditor.getTextEditor();
			this._model = textEditor.getModel();
		}
		super.setActiveEditor(targetEditor);
		updateToolbarActions();
		if (_extendedContributor != null)
			_extendedContributor.setActiveEditor(targetEditor);
	}

	public void setInnerActivePage(IEditorPart activeEditor) {
		// This contributor is designed for StructuredTextMultiPageEditorPart.
		// To safe-guard this from problems caused by unexpected usage by
		// other editors, the following
		// check is added.
		if (_htmlEditor != null) {
			if (activeEditor instanceof StructuredTextEditor) {
				activateSourcePage((StructuredTextEditor) activeEditor);
			} else if (activeEditor instanceof SimpleGraphicalEditor) {
				SimpleGraphicalEditor graphEditor = (SimpleGraphicalEditor) activeEditor;
				activateDesignPage((SimpleGraphicalEditor) activeEditor);
				this._viewer = graphEditor.getGraphicViewer();
			} else {
				// currently we don't have special action for preview.
				deactivateSourceAndDesignPage(activeEditor);
				this._viewer = null;
			}
		}

		updateToolbarActions();

		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			// update menu bar and tool bar
			actionBars.updateActionBars();
		}
	}

	/**
	 * 
	 */
	protected void deactivateSourceAndDesignPage(IEditorPart activeEditor) {
		if (_designViewerActionBarContributor != null) {
			_designViewerActionBarContributor.setActiveEditor(_htmlEditor);
			_designViewerActionBarContributor
					.setViewerSpecificContributionsEnabled(false);
		}
		if (_sourceViewerActionContributor != null) {
			_sourceViewerActionContributor.setActiveEditor(_htmlEditor);
			_sourceViewerActionContributor
					.setViewerSpecificContributionsEnabled(false);
		}
	}

	protected void activateDesignPage(SimpleGraphicalEditor activeEditor) {

		if (_sourceViewerActionContributor != null /*
													 * &&
													 * _sourceViewerActionContributor
													 * instanceof
													 * ISourceViewerActionBarContributor
													 */) {
			// previously I was trying setActiveEditor(null) here. But as in the
			// super class will
			// compare the editor with original one, if same then directly
			// return. So will not disable
			// those actions. (lium)
			_sourceViewerActionContributor.setActiveEditor(_htmlEditor);
			_sourceViewerActionContributor
					.setViewerSpecificContributionsEnabled(false);
		}

		if (_designViewerActionBarContributor != null) {
			_designViewerActionBarContributor.setActiveEditor(activeEditor);
			_designViewerActionBarContributor
					.setViewerSpecificContributionsEnabled(true);
		}
	}

	protected void activateSourcePage(StructuredTextEditor activeEditor) {
		if (_designViewerActionBarContributor != null /*
														 * &&
														 * _designViewerActionBarContributor
														 * instanceof
														 * IDesignViewerActionBarContributor
														 */) {
			// _designViewerActionBarContributor only recogonize HTMLEditor and
			// its own GraphicEditor. so not setting source editor to it.
			_designViewerActionBarContributor.setActiveEditor(_htmlEditor);
			_designViewerActionBarContributor
					.setViewerSpecificContributionsEnabled(false);
		}

		if (_sourceViewerActionContributor != null /*
													 * &&
													 * _sourceViewerActionContributor
													 * instanceof
													 * ISourceViewerActionBarContributor
													 */) {
			_sourceViewerActionContributor.setActiveEditor(activeEditor);
			((ISourceViewerActionBarContributor) _sourceViewerActionContributor)
					.setViewerSpecificContributionsEnabled(true);
		}
	}

	private void updateEditorMenu(IMenuManager menuMgr) {
		if (this._viewer == null) {
			return;
		} else {
			if (menuMgr != null) {
				ContainerActionGroup containerActionGroup = new ContainerActionGroup();
				ActionContext context = new ActionContext(this._viewer
						.getSelection());
				context.setInput(this._viewer);
				containerActionGroup.setContext(context);
				containerActionGroup.fillContextMenu(menuMgr);
				containerActionGroup.setContext(null);

				RangeActionGroup rangeActionGroup = new RangeActionGroup();
				context = new ActionContext(this._viewer.getSelection());
				context.setInput(this._viewer);
				rangeActionGroup.setContext(context);
				rangeActionGroup.fillContextMenu(menuMgr);
				rangeActionGroup.setContext(null);

				SingleElementActionGroup singleActionGroup = new SingleElementActionGroup();
				singleActionGroup.setContext(new ActionContext(this._viewer
						.getSelection()));
				singleActionGroup.fillContextMenu(menuMgr);
				singleActionGroup.setContext(null);

				if (this._model != null) {
					CustomedContextMenuActionGroup customedMenu = new CustomedContextMenuActionGroup();
					customedMenu.setContext(new ActionContext(_viewer
							.getSelection()));
					customedMenu.setModel(_model);
					customedMenu.setParentControl(_viewer.getControl());
					customedMenu.fillContextMenu(menuMgr);
					customedMenu.setContext(null);
					customedMenu.setParentControl(null);
					customedMenu.setModel(null);
				}
			}
		}
	}
}
