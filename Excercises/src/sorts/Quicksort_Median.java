package sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class Quicksort_Median {

	public static double median_finder(ArrayList<Integer> arr) {
		
		ArrayList<Integer> rarr = new ArrayList<>();
		ArrayList<Integer> barr = new ArrayList<>();
		
		int pivot = arr.size()/2;
		

	}

	public static void main(String[] args) {
		int[] arr = {1, 231, 112, 4, 2, 12, 7, 9, 9};
		ArrayList<Integer> arrl = new ArrayList<>();
		for (int i : arr)
			arrl.add(i);
		System.out.println(median_finder(arrl));
	}

}

