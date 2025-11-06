package org.eclipse.swt.snippets;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class SnippetTest {

	public static void main(String s[]) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(1010, 1010);
		Composite composite = new Composite(shell, SWT.BORDER);
//		composite.setLayout(layout);
		composite.setAutoscaleDisabled(true);
		composite.setBounds(100, 100, 1100, 1100);
		Composite inner = new Composite(composite, SWT.BORDER);
//		inner.setLayout(layout);
		inner.setBounds(500, 500, 500, 500);
		Composite inner2 = new Composite(inner, SWT.BORDER);
		inner2.setBounds(0, 0, 250, 250);
		Button button = new Button(shell, SWT.PUSH);
		button.setBounds(0, 0, 50, 50);
		button.setText("Click here");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				composite.setBounds(composite.getBounds());
				inner.setBounds(inner.getBounds());
				inner2.setBounds(inner2.getBounds());
			}
		});
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
