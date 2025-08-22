package org.eclipse.swt.events;

import java.util.concurrent.atomic.*;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

/**
 * @since 3.131
 */
public class ZoomChangedEvent extends Event {

	private AtomicInteger handleDPIChangedScheduledTasksCount;
	private Shell shell;
	private float scalingFactor;

	public ZoomChangedEvent(Shell shell, Widget widget, int zoom, float scalingFactor) {
		this(shell, widget, zoom, scalingFactor, new AtomicInteger(0));
	}

	private ZoomChangedEvent(Shell shell, Widget widget, int zoom, float scalingFactor, AtomicInteger handleDPIChangedScheduledTasksCount) {
		this.shell = shell;
		this.widget = widget;
		this.handleDPIChangedScheduledTasksCount = handleDPIChangedScheduledTasksCount;
		this.scalingFactor = scalingFactor;
		this.detail = zoom;
		this.doit = true;
		this.type = SWT.ZoomChanged;
	}

	public AtomicInteger getHandleDPIChangedScheduledTasksCount() {
		return handleDPIChangedScheduledTasksCount;
	}

	public Shell getShell() {
		return shell;
	}

	public float getScalingFactor() {
		return scalingFactor;
	}

	public ZoomChangedEvent createFor(Widget widget) {
		ZoomChangedEvent event = new ZoomChangedEvent(shell, widget, detail, scalingFactor, handleDPIChangedScheduledTasksCount);
		return event;
	}
}
