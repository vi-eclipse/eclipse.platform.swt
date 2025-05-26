/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.graphics;


import org.eclipse.swt.*;
import org.eclipse.swt.internal.win32.*;

/**
 * Instances of this class are descriptions of GCs in terms
 * of unallocated platform-specific data fields.
 * <p>
 * <b>IMPORTANT:</b> This class is <em>not</em> part of the public
 * API for SWT. It is marked public only so that it can be shared
 * within the packages provided by SWT. It is not available on all
 * platforms, and should never be called from application code.
 * </p>
 * @see <a href="http://www.eclipse.org/swt/">Sample code and further information</a>
 * @noreference This class is not intended to be referenced by clients
 */
public final class GCData {
	public Device device;
	public int style;
	int state = -1;
	public int foreground = -1;
	public int background = -1;
	public Font font;
	Pattern foregroundPattern;
	long gdipFgPatternBrushAlpha;
	Pattern backgroundPattern;
	long gdipBgPatternBrushAlpha;
	int lineStyle = SWT.LINE_SOLID;
	float lineWidth;
	int lineCap = SWT.CAP_FLAT;
	int lineJoin = SWT.JOIN_MITER;
	float lineDashesOffset;
	float[] lineDashes;
	float lineMiterLimit = 10;
	int alpha = 0xFF;
	public int nativeZoom;

	public Image image;
	public PAINTSTRUCT ps;
	public int layout = -1;
	long hPen, hOldPen;
	long hBrush, hOldBrush;
	long hNullBitmap;
	public long hwnd;
	public long  gdipGraphics, gdipPen, gdipBrush, gdipFgBrush, gdipBgBrush,
		gdipFont, hGDIFont;
	float gdipXOffset, gdipYOffset;
	public int uiState = 0;
	public boolean focusDrawn;

	void copyTo(GCData originalData) {
		originalData.device = device;
		originalData.style = style;
		originalData.foreground = foreground;
		originalData.background = background;
		originalData.font = font;
		originalData.nativeZoom = nativeZoom;
		originalData.image = image;
		originalData.ps = ps;
		originalData.layout = layout;
		originalData.hwnd = hwnd;
		originalData.uiState = uiState;
		originalData.focusDrawn = focusDrawn;
	}
}
