package sorts;

import java.util.ArrayList;

public class Quicksort_Median {

	public static int quicksort_median(int[] arr) {
		if (arr.length%2 == 0)
			return -1;
		ArrayList<Integer> less_arr = new ArrayList<>();
		ArrayList<Integer> greater_arr = new ArrayList<>();
		
		int pivot = arr.length/2;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[pivot])
				less_arr.add(arr[i]);
			else if (arr[i] > arr[pivot])
				greater_arr.add(arr[i]);
		}
		
		int[] result = null;
		
		if (less_arr.size() == greater_arr.size()) {
			return arr[pivot];
		} else if (less_arr.size() > greater_arr.size()) {
			result = new int[less_arr.size()];
			for (int i = 0; i < less_arr.size(); i++)
				result[i] = (int) less_arr.toArray()[i];
			return quicksort_median(result);
		} else {
			result = new int[greater_arr.size()];
			for (int i = 0; i < greater_arr.size(); i++)
				result[i] = (int) greater_arr.toArray()[i];
			return quicksort_median(result);
		}
				
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 7, 3, 2, 1, 23, 5};
		System.out.println(quicksort_median(arr));
	}

}
