package com.satyam.common;

public class ArrayUtils {

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void print(int[] arr, String delimiter) {
        for (int i : arr) {
            if ("\n".equals(delimiter)) {
                System.out.println(i);
            } else {
                System.out.print(i + delimiter);
            }
        }
    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
