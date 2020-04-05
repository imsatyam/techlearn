package com.satyam.operation.search;

public class SortedAndRotatedArraySearch {

    private static int doSortedAndRotatedArraySearch(int[] arr, int element, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (arr[low] <= arr[mid]) {  // is left side sorted
                if (arr[mid] > element && arr[low] <= element) {
                    return doSortedAndRotatedArraySearch(arr, element, low, mid - 1);
                }
                return doSortedAndRotatedArraySearch(arr, element, mid + 1, high);
            }

            // right side must be sorted otherwise
            if (element > arr[mid] && element <= arr[high]) {
                return doSortedAndRotatedArraySearch(arr, element, mid + 1, high);
            }
            return doSortedAndRotatedArraySearch(arr, element, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int index = doSortedAndRotatedArraySearch(arr, 8, 0, arr.length - 1);
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not Found");
        }
    }
}
