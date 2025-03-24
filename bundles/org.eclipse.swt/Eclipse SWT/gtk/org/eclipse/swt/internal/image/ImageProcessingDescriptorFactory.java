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

public final class ImageProcessingDescriptorFactory {

	private ImageProcessingDescriptorFactory() {
	}

	public static ImageProcessingDescriptor createDisabledImageProcessingDescriptor() {
		return new RGBImageProcessingDescriptor(0.5f, 0.5f, 0.5f, 0.5f);
	}

	public static ImageProcessingDescriptor createLegacyDisabledImageProcessingDescriptor(Device device) {
		return new RGBImageProcessingDescriptor(0.5f, 0.5f, 0.5f, 0.5f);
	}

}
