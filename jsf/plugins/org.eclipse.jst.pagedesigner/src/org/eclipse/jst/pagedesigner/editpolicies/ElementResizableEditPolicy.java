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
package org.eclipse.jst.pagedesigner.editpolicies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.jst.pagedesigner.IHTMLConstants;
import org.eclipse.jst.pagedesigner.IJMTConstants;
import org.eclipse.jst.pagedesigner.commands.single.ChangeStyleCommand;
import org.eclipse.jst.pagedesigner.common.utils.StringUtil;
import org.eclipse.jst.pagedesigner.css2.ICSSStyle;
import org.eclipse.jst.pagedesigner.css2.layout.BlockBox;
import org.eclipse.jst.pagedesigner.css2.layout.CSSFigure;
import org.eclipse.jst.pagedesigner.css2.layout.MultiLineLabel;
import org.eclipse.jst.pagedesigner.dom.EditModelQuery;
import org.eclipse.jst.pagedesigner.editors.palette.IPaletteItemCategory;
import org.eclipse.jst.pagedesigner.editors.palette.IPaletteItemDescriptor;
import org.eclipse.jst.pagedesigner.editors.palette.impl.PaletteItemManager;
import org.eclipse.jst.pagedesigner.parts.ElementEditPart;
import org.eclipse.jst.pagedesigner.requests.LocationModifierRequest;
import org.eclipse.jst.pagedesigner.utils.CMUtil;
import org.eclipse.jst.pagedesigner.utils.StructuredModelUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author mengbo
 * @version 1.5
 */
public class ElementResizableEditPolicy extends ResizableEditPolicy {
	private static final Insets INSETS_1 = new Insets(1, 1, 1, 1);

	private static final int THRESHHOLD = 3;

	private static final Insets INSETS_CONST = new Insets(THRESHHOLD,
			THRESHHOLD, THRESHHOLD, THRESHHOLD);

	private boolean _showLabelFeedback = true;

	private IFigure[] _hoverFeedbackFigure;

	public static Color HOVER_FEEDBACK_COLOR = ColorConstants.darkBlue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	public void showTargetFeedback(Request request) {
		if (RequestConstants.REQ_SELECTION_HOVER.equals(request.getType())) {
			if (_hoverFeedbackFigure != null) {
				for (int i = 0; i < _hoverFeedbackFigure.length; i++) {
					removeFeedback(_hoverFeedbackFigure[i]);
				}
				_hoverFeedbackFigure = null;
			}
			_hoverFeedbackFigure = showHoverFeedback(request);
		} else {
			super.showTargetFeedback(request);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	public void eraseTargetFeedback(Request request) {
		if (RequestConstants.REQ_SELECTION_HOVER.equals(request.getType())) {
			if (_hoverFeedbackFigure != null) {
				for (int i = 0; i < _hoverFeedbackFigure.length; i++) {
					removeFeedback(_hoverFeedbackFigure[i]);
				}
				_hoverFeedbackFigure = null;
			}
		} else {
			super.eraseTargetFeedback(request);
		}
	}

	/**
	 * @param request
	 */
	private IFigure[] showHoverFeedback(Request request) {
		if (!shouldUseObjectMode(request) && !isStyleTags(getHost())) {
			return null;
		}

		IFigure figure = this.getHostFigure();
		Rectangle[] rects;
		if (figure instanceof CSSFigure) {
			rects = ((CSSFigure) figure).getFragmentsBounds();
		} else {
			rects = new Rectangle[] { figure.getBounds() };
		}
		IFigure[] figures = new IFigure[rects.length
				+ (_showLabelFeedback ? 1 : 0)];
		for (int i = 0; i < rects.length; i++) {
			RectangleFigure fig = new RectangleFigure();
			fig.setFill(false);
			fig.setOutline(true);
			fig.setLineWidth(1);
			fig.setForegroundColor(HOVER_FEEDBACK_COLOR);
			addFeedback(fig);

			Rectangle r = rects[i].getCopy();
			figure.translateToAbsolute(r);
			fig.translateToRelative(r);
			fig.setBounds(r);

			figures[i] = fig;
		}
		if (_showLabelFeedback) {
			Label label = new MultiLineLabel();
			label.setOpaque(true);
			label.setBackgroundColor(ColorConstants.yellow);
			// label.setBorder(new LineBorder(HOVER_FEEDBACK_COLOR, 1));
			label.setForegroundColor(HOVER_FEEDBACK_COLOR);
			label.setText(getTooltipText());
			addFeedback(label);
			// use last rect's bottom left as the label's left top
			Point leftTop = new Point(rects[rects.length - 1].getBottomLeft());
			figure.translateToAbsolute(leftTop);
			label.translateToRelative(leftTop);
			Dimension d = label.getPreferredSize();
			Rectangle rect = new Rectangle(leftTop, d);

			// to avoid enlarge feedback pane.
			rect = rect.intersect(getFeedbackLayer().getBounds());
			label.setBounds(rect);

			figures[rects.length] = label;
		}
		return figures;
	}

	private String getTooltipText() {
		Element element = (Element) this.getHost().getModel();
		StringBuffer text = new StringBuffer();
		text.append("<").append(element.getTagName()).append(">");

		PaletteItemManager manager = PaletteItemManager
				.getInstance(getProject(element));
		if (manager != null) {
			IPaletteItemCategory category = manager.findOrCreateCategory(CMUtil
					.getElementNamespaceURI(element), null);
			if (category != null) {
				String name = element.getLocalName();
				if (category.getURI().equals(IJMTConstants.URI_JSP)) {
					name = element.getTagName();
				}
				IPaletteItemDescriptor descriptor = category
						.getItemByTagName(name);
				if (category.getURI().equals(IJMTConstants.URI_HTML)
						&& IHTMLConstants.TAG_INPUT.equalsIgnoreCase(name)) {
					String type = element
							.getAttribute(IHTMLConstants.ATTR_TYPE);
					if (IHTMLConstants.TYPE_SUBMIT.equalsIgnoreCase(type)) {
						descriptor = category.getItemByID("html:INPUT:Button");
					} else if (IHTMLConstants.TYPE_CHECKBOX
							.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Check Box");
					} else if (IHTMLConstants.TYPE_RADIO.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Radio Button");
					} else if (IHTMLConstants.TYPE_IMAGE.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Image Button");
					} else if (IHTMLConstants.TYPE_PASSWORD
							.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Password Field");
					} else if (IHTMLConstants.TYPE_TEXT.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Text Field");
					} else if (IHTMLConstants.TYPE_HIDDEN
							.equalsIgnoreCase(type)) {
						descriptor = category
								.getItemByID("html:INPUT:Hidden Field");
					}
				}

				if (descriptor != null) {
					text.append("\n").append(
							StringUtil.filterConvertString(descriptor
									.getDescription()));
				}
			}
		}

		if (text.toString().endsWith("\n")) {
			return text.substring(0, text.length() - 1);
		}
		return text.toString();
	}

	private IProject getProject(Element element) {
		if (element instanceof IDOMElement) {
			IDOMModel model = ((IDOMElement) element).getModel();
			IFile file = StructuredModelUtil.getFileFor(model);
			if (file != null) {
				return file.getProject();
			}
		}
		return null;
	}

	private boolean isStyleTags(EditPart part) {
		if (part != null && part.getModel() instanceof Node) {
			return EditModelQuery.HTML_STYLE_NODES.contains(((Node) part
					.getModel()).getNodeName());
		} else {
			return false;
		}
	}

	/**
	 * @param request
	 * @return
	 */
	public boolean shouldUseObjectMode(Request request) {
		ElementEditPart part = (ElementEditPart) this.getHost();
		if (isStyleTags(part)) {
			return false;
		}
		if (part.isWidget()
				|| (!part.canHaveDirectTextChild() && !part
						.haveNonWhitespaceTextChild())) {
			return true;
		}
		if (request instanceof SelectionRequest
				&& ((SelectionRequest) request).isControlKeyPressed()) {
			return true;
		}
		if (request instanceof LocationModifierRequest
				&& ((LocationModifierRequest) request).isControlKeyPressed()) {
			return true;
		}

		// for other elements
		if (request instanceof LocationRequest) {
			Point location = ((LocationRequest) request).getLocation()
					.getCopy();
			part.getFigure().translateToRelative(location);
			return shouldUseObjectMode(location);
		} else {
			return false; // should not happen
		}
	}

	/**
	 * @param location
	 * @return
	 */
	private boolean shouldUseObjectMode(Point location) {
		// when the location is close to the border/padding of the element, then
		// we think it is default to
		// object mode selection.
		CSSFigure figure = (CSSFigure) this.getHostFigure();
		if (figure.getFragmentsBounds().length != 1) {
			return false;
		}
		Rectangle bounds = figure.getBounds().getCopy();
		Insets insets = figure.getInsets();
		bounds.crop(insets);
		if (insets.top > THRESHHOLD && insets.left > THRESHHOLD
				&& insets.right > THRESHHOLD && insets.bottom > THRESHHOLD) {
			return !bounds.contains(location);
		}

		// since the figure insets could be 0, so we expand it a little, thus
		// even the point is
		// a little inside the content area, we still think it is selection the
		// object.
		if (bounds.height < 3 * THRESHHOLD || bounds.width < 3 * THRESHHOLD) {
			bounds.crop(INSETS_1);
		} else {
			bounds.crop(INSETS_CONST);
		}
		return !bounds.contains(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#createSelectionHandles()
	 */
	protected List createSelectionHandles() {
		// we have three different kinds of handles.
		// 1. Those element that is resizable.
		// 2. Those element that is rectangle but not resizable.
		// 3. Those element that is not rectangle (fragments)

		IFigure figure = this.getHostFigure();
		if (figure instanceof CSSFigure && getHost() instanceof ElementEditPart) {
			CSSFigure cssfigure = (CSSFigure) figure;
			List fragments = cssfigure.getFragmentsForRead();

			// XXX: only one fragment and is blockbox, then we think it is
			// resizable by figure
			// should move this test to somewhere else.
			if (fragments != null && fragments.size() == 1
					&& fragments.get(0) instanceof BlockBox) {
				if (((ElementEditPart) getHost()).isResizable()) {
					// super is Resizable policy, will create a resize handles.
					return super.createSelectionHandles();
				} else {
					return createNonResizeHandles();
				}
			} else {
				return createFragmentsHandles();
			}
		} else {
			// second case
			return createNonResizeHandles();
		}
	}

	/**
	 * @return
	 */
	private List createFragmentsHandles() {
		List list = new ArrayList();
		list.add(new FragmentHandle((GraphicalEditPart) getHost()));
		return list;
	}

	/**
	 * @return
	 */
	private List createNonResizeHandles() {
		// following code copied from NonResizableEditPolicy
		List list = new ArrayList();
		if (isDragAllowed()) {
			NonResizableHandleKit.addHandles((GraphicalEditPart) getHost(),
					list);
		} else {
			NonResizableHandleKit.addHandles((GraphicalEditPart) getHost(),
					list, new SelectEditPartTracker(getHost()),
					SharedCursors.ARROW);
		}

		return list;
	}

	/**
	 * child class could override this method.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	protected Command getResizeCommand(IDOMElement element, int width,
			int height) {
		Map map = new HashMap();
		if (width > 0) {
			map.put("width", width + "px");
		}
		if (height > 0) {
			map.put("height", height + "px");
		}
		if (map.isEmpty()) {
			return null;
		} else {
			return new ChangeStyleCommand(element, map);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#getResizeCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 */
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		ElementEditPart part = (ElementEditPart) this.getHost();

		Rectangle rect = part.getFigure().getBounds();
		rect = request.getTransformedRectangle(rect);
		int width = rect.width;
		int height = rect.height;

		// since the user dragged rectangle included border/padding of the
		// element. And if the element's
		// width/height style setting don't include border padding, then we need
		// to set the element's width/height
		// style property a little smaller.
		if (part.getFigure() instanceof CSSFigure) {
			CSSFigure cssfigure = (CSSFigure) part.getFigure();
			ICSSStyle style = cssfigure.getCSSStyle();
			if (style != null && !style.isSizeIncludeBorderPadding()) {
				width -= (style.getBorderInsets().getWidth() + style
						.getPaddingInsets().getWidth());
				height -= (style.getBorderInsets().getHeight() + style
						.getPaddingInsets().getHeight());
			}
		}
		return getResizeCommand((IDOMElement) part.getIDOMNode(), width, height);
	}

	/**
	 * Shows or updates feedback for a change bounds request.
	 * 
	 * @param request
	 *            the request
	 */
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		IFigure feedback = getDragSourceFeedbackFigure();

		PrecisionRectangle rect = new PrecisionRectangle(
				getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());

		// to avoid enlarge feedback pane.
		// when draging a editpart inside designer to move/copy it, we do not
		// want to
		// enlarge the canvas, since that may resulting in relayout.
		rect = (PrecisionRectangle) rect.intersect(getFeedbackLayer()
				.getBounds());

		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}
}
