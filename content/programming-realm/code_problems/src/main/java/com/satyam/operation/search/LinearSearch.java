package com.satyam.operation.search;

public class LinearSearch {

    public static int doLinearSearch(int[] arr, int element) {

        for (int i = 0; i < arr.length; i++) {
            if (i == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int index = doLinearSearch(arr, 5);
        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not Found");
        }
    }

}
