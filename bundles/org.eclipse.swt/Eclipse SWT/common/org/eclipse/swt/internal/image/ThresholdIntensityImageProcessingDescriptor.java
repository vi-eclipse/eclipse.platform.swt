/*******************************************************************************
 * Copyright (c) 2025 Vector Informatik GmbH and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.swt.internal.image;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;

public class ThresholdIntensityImageProcessingDescriptor implements ImageProcessingDescriptor {

	private final RGBA lowIntensity;
	private final RGBA highIntensity;

	public ThresholdIntensityImageProcessingDescriptor(Device device) {
		this.lowIntensity = device.getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW).getRGBA();
		this.highIntensity = device.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND).getRGBA();
	}

	@Override
	public RGBA adaptPixelValue(RGBA original) {
		int red = original.rgb.red;
		int green = original.rgb.green;
		int blue = original.rgb.blue;
		int intensity = red * red + green * green + blue * blue;
		RGBA usedValue = intensity < 98304 ? lowIntensity : highIntensity;
		return new RGBA(usedValue.rgb.red, usedValue.rgb.green, usedValue.rgb.blue, original.alpha);
	}

}
