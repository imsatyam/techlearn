package com.satyam.operation.search;

/**

 1. Find index of middle element
 2. Compare middle element with its neighbours (if neighbours exist)
 3. If middle element is not peak and its left neighbor is greater than it,then left half must have a peak element
 4. If middle element is not peak and its right neighbor is greater than it, then right half must have a peak element

 */

public class PeakElementIn1DArrayFinder {

    public static int findPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid+1]<= arr[mid])) {
                return mid;
            }

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 20, 4, 1, 0};
        int peak = findPeakElement(arr);
        if (peak != -1) {
            System.out.println("Found at index: " + peak);
        } else {
            System.out.println("Not Found");
        }
    }
}
