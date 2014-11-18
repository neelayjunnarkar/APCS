Sort Algorithms
===============
    by Neelay Junnarkar

Neelay Junnarkar APCS 2nd Period Mr. Kuszmaul

This Program implements 3 array sorting methods: Bubblesort, Insertionsort, and Selectionsort

Bubblesort:
    The method repeatedly iterates through the array, switching consecutive
    numbers into Low -> High order, until the array is sorted Low -> High

Insertionsort:
    The method assumes 2 subarrays: one with indexes [0..i], where i is the current index,
    and the second with indexes [i+1, end]. The method takes the first element of the
    second subarray and inserts it into the correct location in the first subarray,
    placing it before elements that are greater than it and after elements that are
    less than or equal to it.

Selectionsort:
    The method iterates through the array, Left -> Right, switching the element at the current index
    with the lowest value element with a greater index, thereby sorting the array, Lowest -> Highest (value)

Example Output:

        Original array: 5 3 213 12 2 12 3 4 21 12 3 4 12 123 3 2 12 3 23 4 123 1 12 3 4 214 12 3 1 2312 1 23 1 23 14 1
        Bubblesort:     1 1 1 1 1 2 2 3 3 3 3 3 3 3 4 4 4 4 5 12 12 12 12 12 12 12 14 21 23 23 23 123 123 213 214 2312
        Insertionsort:  1 1 1 1 1 2 2 3 3 3 3 3 3 3 4 4 4 4 5 12 12 12 12 12 12 12 14 21 23 23 23 123 123 213 214 2312
        Selectionsort:  1 1 1 1 1 2 2 3 3 3 3 3 3 3 4 4 4 4 5 12 12 12 12 12 12 12 14 21 23 23 23 123 123 213 214 2312
        Original array: 5 3 213 12 2 12 3 4 21 12 3 4 12 123 3 2 12 3 23 4 123 1 12 3 4 214 12 3 1 2312 1 23 1 23 14 1

    As above, each sort method orders the elements in the original array from least to greatest.