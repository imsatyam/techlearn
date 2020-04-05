package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 Complexity:
     Best: Ω(n log(n))
     Average: θ(n log(n))
     Worst: O(n log n)

 */

public class MergeSort {

    private static void doMergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            doMergeSort(arr, low, mid);
            doMergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[(mid + 1) + j];
        }

        int i = 0, j = 0, k = low;

        while(i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(i < n1) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doMergeSort(arr, 0, arr.length - 1);
        ArrayUtils.print(arr, " ");
    }

}
