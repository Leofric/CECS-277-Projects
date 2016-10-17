package edu.project.four;

/**
 * This class formatts string objects to be used by the measurable class
 * 
 * @author alexberthon
 * @version 1.0
 */
public class MeasurableString extends Measurable implements Comparable {

	private final String data;

	/**
	 * Constructor
	 * 
	 * @param string
	 *            string to be converted to type MeasurableString
	 */
	public MeasurableString(String string) {
		data = string;
	}

	/**
	 * Overrides the toString method for this object
	 */
	public String toString() {
		return data;
	}

	/**
	 * extends from abstract method, returns what to measure
	 */
	public double getMeasure() {
		return (double) data.length();
	}

	/**
	 * This method defines the compareTo method, compares two measurable string
	 * objects
	 * 
	 * @param object
	 *            the object to compare
	 * @return value indicating the larger string
	 */
	public int compareTo(Object object) {
		int returned;
		if (data.length() > ((MeasurableString) object).getMeasure()) {
			returned = 1;
		} else if (data.length() < ((MeasurableString) object).getMeasure()) {
			returned = -1;
		} else
			returned = 0;
		return returned;
	}
}