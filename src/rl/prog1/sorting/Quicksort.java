package rl.prog1.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Provides two versions of the quicksort algorithm and a main method
 * template for performance measurements.
 * @author Ruediger Lunde
 *
 */
public class Quicksort {
	private int[] data;

	/**
	 * Sorts the provided data using quicksort. By specifying whether
	 * to use the rightmost element as pivot element or an element from
	 * the middle, the caller can choose between two versions of the algorithm.
	 */
	public void sort(int[] data, boolean pivotFromMiddle) {
		// Check for empty or null array
		if (data == null || data.length == 0) {
			return;
		}
		this.data = data;
		if (pivotFromMiddle)
			qsort1(0, data.length - 1);
		else
			qsort2(0, data.length - 1);
	}

	// Modified version of
	// http://www.vogella.de/articles/JavaAlgorithmsQuicksort/article.html
	/** First version which takes the pivot element from the middle. */
	private void qsort1(int left, int right) {
		int i = left, j = right;
		// Get the pivot element from the middle of the list
		int pivot = data[left + (right - left) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (data[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (data[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (left < j)
			qsort1(left, j);
		if (i < right)
			qsort1(i, right);
	}

	/** Second version which uses the rightmost element as pivot element. */
	private void qsort2(int left, int right) {
		if (left < right) {
			int i = partition(left, right);
			qsort2(left, i - 1);
			qsort2(i + 1, right);
		}
	}

	private int partition(int left, int right) {
		int i = left, j = right - 1;
		int pivot = data[right];
		do {
			while (data[i] <= pivot && i < right)
				i++;
			while (data[j] >= pivot && j > left)
				j--;
			if (i < j)
				swap(i, j);
		} while (i < j);
		if (data[i] > pivot)
			swap(i, right);
		return i;
	}

	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/** Prints the current data for testing purposes. */
	public void print() {
		int i = 0;
		for (int num : data) {
			if (i++ % 100 == 0)
				System.out.println();
			System.out.print(num + " ");
		}
		System.out.println();
	}

	/**
	 * Test method. Find out, how the tree versions of Quicksort (including
	 * {@link Arrays#sort(int[])} perform with sorted and unsorted
	 * data.
	 */
	public static void main(String[] args) {
		// select what you want to test
		boolean enableRandom = false;
		int sorterVersion = 1;
		int arrayLength = 1000;
		// ok - here we go...
		Quicksort sorter = new Quicksort();
		int[] data = new int[arrayLength];
		Random rand = new Random();
		for (int i = 0; i < data.length; i++)
			data[i] = enableRandom ? rand.nextInt(arrayLength) : i;
		int mcount = 1000;
		long t1, t2, t = 0;
		for (int i = 0; i < mcount; i++) {
			int[] d = data.clone();
			t1 = System.nanoTime();
			switch (sorterVersion) {
			case 1:
				sorter.sort(d, true);
				break;
			case 2:
				sorter.sort(d, false);
				break;
			case 3:
				Arrays.sort(d);
				break;
			}
			t2 = System.nanoTime();
			t += t2 - t1;
		}
		// sorter.print();
		System.out.printf("Time: %d msec\n", t / mcount / 1000);
	}
}
