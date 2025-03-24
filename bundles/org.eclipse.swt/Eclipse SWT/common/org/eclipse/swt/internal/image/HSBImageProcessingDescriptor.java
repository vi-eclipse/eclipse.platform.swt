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

public class HSBImageProcessingDescriptor implements ImageProcessingDescriptor {

	private final float hueFactor;
	private final float saturationFactor;
	private final float brightnessFactor;
	private final float alphaFactor;

	public HSBImageProcessingDescriptor(float hueFactor, float saturationFactor, float brightnessFactor, float alphaFactor) {
		this.hueFactor = hueFactor;
		this.saturationFactor = saturationFactor;
		this.brightnessFactor = brightnessFactor;
		this.alphaFactor = alphaFactor;
	}

	@Override
	public RGBA adaptPixelValue(RGBA original) {
		float[] hsba = original.getHSBA();
		hsba[0] = Math.min(hueFactor * hsba[0], 1.0f);
		hsba[1] = Math.min(saturationFactor * hsba[1], 1.0f);
		hsba[2] = Math.min(brightnessFactor * hsba[2], 1.0f);
		hsba[3] = Math.min(alphaFactor * hsba[3], 255.0f);

		return new RGBA(hsba[0], hsba[1], hsba[2], hsba[3]);
	}

}
