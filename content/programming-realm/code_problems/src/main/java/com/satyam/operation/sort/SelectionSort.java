package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 Philosophy:
    Sorted array - beginning, unsorted array-end
    pick smallest element from the unsorted array and insert into sorted array.

 Complexity:
     Best: Ω(n^2)
     Average: θ(n^2)
     Worst: O(n^2)

 */

public class SelectionSort {

    private static void doSelectionSort(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) { // sorted sublist
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            ArrayUtils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doSelectionSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }

}
