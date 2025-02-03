/*******************************************************************************
 * Copyright (c) 2000, 2017 IBM Corporation and others.
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
package org.eclipse.swt.internal.ole.win32;

import java.util.concurrent.atomic.*;

public class IUnknown
{
	private static AtomicInteger callsCount = new AtomicInteger();
	long address;
public IUnknown(long address) {
	this.address = address;
}
public int AddRef() {
	trace("IUnknown.AddRef()");
	return COM.VtblCall(1, address);
}
public long getAddress() {
	return address;
}
public int QueryInterface(GUID riid, long[] ppvObject) {
	trace("IUnknown.QueryInterface()");
	return COM.VtblCall(0, address, riid, ppvObject);
}
public int Release() {
	trace("IUnknown.Release()");
	return COM.VtblCall(2, address);
}

protected void trace(String s) {
	System.out.println(s+" [call nr. " + callsCount.incrementAndGet() + "]");
}
}
