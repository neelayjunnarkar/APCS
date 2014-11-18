package sorts;

public class Sort {

    /**
     * A sort method that implements the bubblesort technique
     * The method repeatedly iterates through the array,
     *      switching consecutive numbers into Low -> High order,
     *      until the array is sorted Low -> High
     * @param arg an argument of type int[]
     * @return returns arg sorted
     */
    public static int[] bubblesort(int[] arg) {
        int[] arr = new int[arg.length];

        for (int i = 0; i < arg.length; i++)
            arr[i] = arg[i];

        boolean swapped = true;
        while (swapped) { //the method continues to iterate through and switch pairs until there are no more pairs to be switched
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    swapped = true;
                    continue;
                }
            }
        }
        return arr;
    }

    /**
     * A sort method that implements the insertionsort technique
     * The method assumes 2 subarrays: one with indexes [0..i], where i is the current index,
     *      and the second with indexes [i+1, end]. The method takes the first element of the
     *      second subarray and inserts it into the correct location in the first subarray,
     *      placing it before elements that are greater than it and after elements that are
     *      less than or equal to it.
     * @param arg an argument of type int[]
     * @return returns arg sorted
     */
    public static int[] insertionsort(int[] arg) {
        int[] arr = new int[arg.length];

        for (int i = 0; i < arg.length; i++)
            arr[i] = arg[i];

        int n, j;
        for (int i = 0; i < arr.length; i++) {
            n = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > n; j--) { //shift all numbers greater than n one to the right, to make space for inserting n
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = n; //insert n into sorted index
        }

        return arr;
    }

    /**
     *  A sort method that implements the selectionsort technique
     * The method iterates through the array, Left -> Right, switching the element at the current index
     *      with the lowest value element with a greater index, thereby sorting the array, Lowest -> Highest (value)
     * @param arg an argument of type int[]
     * @return returns arg sorted
    */
    public static int[] selectionsort(int[] arg) {
        int[] arr = new int[arg.length];

        for (int i = 0; i < arg.length; i++)
            arr[i] = arg[i];

        int min, j, replace_index = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            for (j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    replace_index = j;
                }
            }
            arr[replace_index] = (arr[replace_index] < arr[i]) ? arr[i] : arr[replace_index];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 213, 12, 2, 12, 3, 4, 21, 12, 3, 4, 12, 123, 3, 2, 12, 3, 23, 4, 123, 1, 12, 3, 4, 214, 12, 3, 1, 2312, 1, 23, 1, 23, 14, 1};
        System.out.print("Original array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

		int[] arrbs = bubblesort(arr);
		System.out.print("Bubblesort:     ");
		for (int i : arrbs)
			System.out.print(i + " ");
		System.out.println();

		int[] arris = insertionsort(arr);
		System.out.print("Insertionsort:  ");
		for (int i : arris)
			System.out.print(i + " ");
		System.out.println();

        int[] arrss = selectionsort(arr);
        System.out.print("Selectionsort:  ");
        for (int i : arrss)
            System.out.print(i + " ");
        System.out.println();

        System.out.print("Original array: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

}