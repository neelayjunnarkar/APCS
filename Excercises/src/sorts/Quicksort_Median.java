package sorts;

import AS_1.Pascal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quicksort_Median {

	public static int[] randArr(int len, int min, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int)Math.round((Math.random()*(max-min))+min);
		}
		return arr;
	}

	/**
	 *
	 * @param arr The array in which 2 elements are switched
	 * @param i The index of one of the elements
	 * @param j The index of the second element
	 * @return The arraylist with the values at the indices swapped
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	/**
	 *
	 * @param arr the array which is partitioned so that pivot elem is in middle and to the left is lesser and to the right is greater
	 * @param first first index of array
	 * @param last last index of array
	 * @return
	 */
	public static int partition(int[] arr, int first, int last) {
		int pivot = arr[first];
		int left = first, right = last;

		while (left < right) {
			while (arr[left] <= pivot && left < right)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left < right)
				swap(arr, left, right);
		}


		swap(arr, first, right);

		return right;
	}

	/**
	 * 
	 * @param arr the array of which the median is found
	 * @param left left-most index
	 * @param right right-most index
	 * @param n The middle index (the index of the median)
	 * @return the median
	 */
	public static int median_finder(int[] arr, int left, int right, int n) {

		if (left >= right)
			return left;

		int r = (int) (Math.random() * (right - left + 1)) + left;
		swap(arr, left, r);

		int pivot = partition(arr, left, right);

		int len = pivot - left;
		if (len > n)
			return median_finder(arr, left, pivot - 1, n);
		if (len < n)
			return median_finder(arr, pivot + 1, right, n - len - 1);

		return pivot;
	}

	/**
	 * As the graph shows in the excel file, this method has a complexity of O(n)
	 * @param args
	 */
	public static void main(String[] args) {
		//tests 3 arrays of lengths 1, 4, 7, 10... so on until 100
		for (int i = 1; i < 101; i+=3) {
			for (int j = 0; j < 1; j++) {
				long t0 = System.nanoTime();
				int[] arr = randArr(i, 0, 100);
				int a = arr[median_finder(arr, 0, arr.length-1, (arr.length+1)/2)];
				long tf = System.nanoTime();
				System.out.println(tf-t0);
			}
			//System.out.println();
		}

	}

}

