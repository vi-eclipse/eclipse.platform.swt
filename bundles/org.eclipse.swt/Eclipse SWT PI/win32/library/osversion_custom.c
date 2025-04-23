/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
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

#include "swt.h"
#include "winversion_structs.h"
#include "winversion_stats.h"

#define WinVersion_NATIVE(func) Java_org_eclipse_swt_internal_win32_version_WinVersion_##func

HINSTANCE g_hInstance = NULL;
BOOL WINAPI DllMain(HANDLE hInstDLL, DWORD dwReason, LPVOID lpvReserved)
{
	/* Suppress warnings about unreferenced parameters */
	(void)lpvReserved;

	if (dwReason == DLL_PROCESS_ATTACH) {
		if (g_hInstance == NULL) g_hInstance = hInstDLL;
	}
	return TRUE;
}
