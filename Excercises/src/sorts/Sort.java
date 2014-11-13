package sorts;

public class Sort {
	
	public static int[] bubblesort(int[] arg) {
		int[] arr = new int[arg.length];
		
		for (int i = 0; i < arg.length; i++)
			arr[i] = arg[i];

		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i-1]) {
					int tmp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = tmp;
					swapped = true;
					continue;
				}
			}
		}
		return arr;
	}
	
	public static int[] insertionsort(int[] arg) {
		int[] arr = new int[arg.length];
		
		for (int i = 0; i < arg.length; i++)
			arr[i] = arg[i];
		
		return arr;	
	}
	
	public static int[] selectionsort(int[] arg) {
		int[] arr = new int[arg.length];
		
		for (int i = 0; i < arg.length; i++)
			arr[i] = arg[i];
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 123, 50, 11, 1};
		System.out.print("Original array: ");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		
//		int[] arrbs = bubblesort(arr);
//		System.out.print("Bubblesort: ");
//		for (int i : arrbs)
//			System.out.print(i + " ");
//		System.out.println();
		
		int[] arrss = selectionsort(arr);
		System.out.print("Selectionsort: ");
		for (int i : arrss)
			System.out.print(i + " ");
		System.out.println();

	}
	
}