package edu.project.four;

import java.util.ArrayList;

/**
 * generic This generic class is used to compare all objects that are Measurable
 * @author alexberthon
 * @version 1.0
 */
public abstract class Measurable {
	public abstract double getMeasure();

	/**
	 * This generic method returns the largest element in an array
	 * @param objects an array of objects, type T
	 * @return the largest element in the array, type T
	 */
	public static <T extends Comparable<T>> T largest(ArrayList<T> objects) {
		T largest = objects.get(0);
		for (T e : objects) {
			if (largest.compareTo(e) < 0) {
				largest = e;
			}
		}
		return largest;
	}
}