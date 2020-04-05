package com.satyam.operation.search;

import java.util.Arrays;

/**
 * It is a simple implementation of binary search.
 *
 * It can be optimized further in terms of the number of comparisons. Please refer to
 * https://www.geeksforgeeks.org/the-ubiquitous-binary-search-set-1/ for more.
 *
 */

public class BinarySearch {

    public static int doBinarySearch(int[] arr, int element, int low, int high) {

        if (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                return doBinarySearch(arr, element, low, mid - 1);
            } else if (arr[mid] < element) {
                return doBinarySearch(arr, element, mid + 1, high);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(arr);
        int index = doBinarySearch(arr, 2, 0, arr.length - 1);
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not Found");
        }
    }

}
