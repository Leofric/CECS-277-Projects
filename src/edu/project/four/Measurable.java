package edu.project.four;

import java.util.ArrayList;

public abstract class Measurable{
	public abstract double getMeasure();

	public static <T extends Comparable<T>> T largest(ArrayList<T> objects) { //U extends T?
		T largest = objects.get(0);
		for (T e:objects){
			if(largest.compareTo(e)<0){
				largest = e;
			}
		}
		return largest;
	}
}