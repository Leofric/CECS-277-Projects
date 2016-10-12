package edu.project.four;

import java.util.ArrayList;

public abstract class Measurable<T> {
	public abstract double getMeasure();

	public static <T extends Measurable<T>, U extends T> T largest(ArrayList<U> objects) {
		T largest = objects.get(0);
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).getMeasure() > largest.getMeasure()) {
				largest = objects.get(i);
			}
		}
		return largest;
	}
}
