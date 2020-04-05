package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 It is about two operations
    - BUILD MAX HEAP
    - HEAPIFY

 Complexity:
     Best: Ω(n log(n))
     Average: θ(n log(n))
     Worst: O(n log n)

 */


public class HeapSort {

    private static void doHeapSort(int[] arr, int n) {
        buildMaxHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            ArrayUtils.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void buildMaxHeap(int[] arr, int n) {
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            ArrayUtils.swap(arr, largest, index);
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doHeapSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }

}
