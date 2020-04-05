package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 Complexity:
     Best: Ω(n)
     Average: θ(n^2)
     Worst: O(n^2)

 */
public class BubbleSort {

    private static void doBubbleSort(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            boolean swap = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap = true;
                    ArrayUtils.swap(arr, j, j+1);
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doBubbleSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }

}
