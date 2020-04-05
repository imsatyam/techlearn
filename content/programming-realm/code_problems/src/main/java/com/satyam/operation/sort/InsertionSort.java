package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 Philosophy:
    Works like sorting of cards
    for 1 to N: pick the element a[i] and insert it into the sorted subsequence a[0 ... i-1]

 Complexity:
     Best: Ω(n)
     Average: θ(n^2)
     Worst: O(n^2)

 */
public class InsertionSort {

    private static void doInsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) { // unsorted sublist

            int key = arr[i];
            int j = i -1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
//
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doInsertionSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }

}
