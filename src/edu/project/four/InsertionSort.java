package edu.project.four;

public class InsertionSort {

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