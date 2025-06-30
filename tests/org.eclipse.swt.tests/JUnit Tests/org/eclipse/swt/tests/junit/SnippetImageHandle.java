package org.eclipse.swt.tests.junit;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageFileNameProvider;
import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SnippetImageHandle {

	@ParameterizedTest
	@ValueSource(ints = {10, 100, 1000})
	public void png(int runs) {
		ImageFileNameProvider imageFileNameProvider = zoom -> "C:\\Users\\amartya.parijat\\Downloads\\superheroe-svgrepo-com.png";
		Image image = new Image(Display.getDefault(), imageFileNameProvider);
		long time = paintImage(image, false, runs);
		System.out.println(time + " ms -> " + runs + " png GC paints");
		time = paintImage(image, true, runs);
		System.out.println(time + " ms -> " + runs + " png GC paints with handle cleaning");
		image.dispose();
	}

	@ParameterizedTest
	@ValueSource(ints = {10, 100, 1000})
	public void svg(int runs) {
		ImageFileNameProvider imageFileNameProvider = zoom -> "C:\\Users\\amartya.parijat\\Downloads\\protein-svgrepo-com.svg";
		Image image = new Image(Display.getDefault(), imageFileNameProvider);
		long time = paintImage(image, false, runs);
		System.out.println(time + " ms -> " + runs + " svg GC paints");
		time = paintImage(image, true, runs);
		System.out.println(time + " ms -> " + runs + " svg GC paints with handle cleaning");
		image.dispose();
	}

	private long paintImage(Image image, boolean cleanHandle, int runs) {
		GC gc = new GC(image);
		long start = System.currentTimeMillis();
		for (int i = 0; i < runs; i++)
			gc.drawImage(image, 0, 0, cleanHandle);
		long end = System.currentTimeMillis();
		gc.dispose();
		return end - start;
	}
}
