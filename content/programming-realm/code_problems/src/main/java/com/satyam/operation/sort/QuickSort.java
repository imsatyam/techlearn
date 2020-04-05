package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

    Partitioning: https://www.youtube.com/watch?v=MZaf_9IZCrc

    Complexity:
        Best: Ω(n log(n))
        Average: θ(n log(n))
        Worst: O(n^2)

 */

public class QuickSort {

    private static void doQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            doQuickSort(arr, low, mid - 1);
            doQuickSort(arr, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }

        ArrayUtils.swap(arr, i+1, high);
        return (i+1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doQuickSort(arr, 0, arr.length - 1);
        ArrayUtils.print(arr, " ");
    }

}
