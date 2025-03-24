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

import org.eclipse.swt.graphics.*;

public class RGBImageProcessingDescriptor implements ImageProcessingDescriptor {

	private final float redFactor;
	private final float greenFactor;
	private final float blueFactor;
	private final float alphaFactor;

	public RGBImageProcessingDescriptor(float redFactor, float greenFactor, float blueFactor, float alphaFactor) {
		this.redFactor = redFactor;
		this.greenFactor = greenFactor;
		this.blueFactor = blueFactor;
		this.alphaFactor = alphaFactor;
	}

	@Override
	public RGBA adaptPixelValue(RGBA original) {
		int red = (int) Math.min(redFactor * original.rgb.red, 255.0f);
		int green = (int) Math.min(greenFactor * original.rgb.green, 255.0f);
		int blue = (int) Math.min(blueFactor * original.rgb.blue, 255.0f);
		int alpha = (int) Math.min(alphaFactor * original.alpha, 255.0f);

		return new RGBA(red, green, blue, alpha);
	}

}
