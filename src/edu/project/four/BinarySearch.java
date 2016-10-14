package edu.project.four;

/**
 * A class for executing binary searches through an array.
 * @param <T>
 */
public class BinarySearch<T extends Comparable<T>> {
	private T[] a;

	/**
	 * Constructs a BinarySearcher.
	 * @param <T>
	 * 
	 * @param anArray
	 *            a sorted array
	 */
	public BinarySearch(T[] anArray) {
		a =  anArray;
	}

	/**
	 * Finds a value in a sorted array, using the binary search algorithm.
	 * 
	 * @param v
	 *            the value to search
	 * @return the index at which the value occurs, or -1 if it does not occur
	 *         in the array
	 */
	public int search(T v) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int diff = a[mid].compareTo(v);

			if (diff == 0) // a[mid] == v
				return mid;
			else if (diff < 0) // a[mid] < v
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}