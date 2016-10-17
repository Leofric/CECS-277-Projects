package edu.project.four;

/**
 * This generic class implements a insertion sort for all types
 * 
 * @author alexberthon
 * @version 1.0
 */
public class InsertionSort {
	/**
	 * This generic method sorts an array of type T via an insertion sort
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		int size = array.length;

		for (int outerLoopIdx = 1; outerLoopIdx < size; ++outerLoopIdx) {
			for (int innerLoopIdx = outerLoopIdx; innerLoopIdx > 0; --innerLoopIdx) {
				if (array[innerLoopIdx - 1].compareTo(array[innerLoopIdx]) > 0) {
					T temp = array[innerLoopIdx - 1];
					array[innerLoopIdx - 1] = array[innerLoopIdx];
					array[innerLoopIdx] = temp;
				}
			}
		}
	}
}