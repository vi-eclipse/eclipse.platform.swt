/*******************************************************************************
 * Copyright (c) 2018, 2023 Red Hat and others. All rights reserved.
 * The contents of this file are made available under the terms
 * of the GNU Lesser General Public License (LGPL) Version 2.1 that
 * accompanies this distribution (lgpl-v21.txt).  The LGPL is also
 * available at http://www.gnu.org/licenses/lgpl.html.  If the version
 * of the LGPL at http://www.gnu.org is different to the version of
 * the LGPL accompanying this distribution and there is any conflict
 * between the two license versions, the terms of the LGPL accompanying
 * this distribution shall govern.
 *
 * Contributors:
 *     Red Hat - initial API and implementation
 */
package org.eclipse.swt.tests.win32;

import org.eclipse.swt.graphics.ImageWin32Tests;
import org.eclipse.swt.tests.win32.widgets.TestTreeColumn;
import org.eclipse.swt.tests.win32.widgets.Test_org_eclipse_swt_widgets_Display;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ImageWin32Tests.class, //
		Test_org_eclipse_swt_dnd_DND.class, //
		Test_org_eclipse_swt_events_KeyEvent.class, //
		Test_org_eclipse_swt_widgets_Display.class, //
		TestTreeColumn.class, //
		Win32DPIUtilTests.class })
public class AllWin32Tests {

}
