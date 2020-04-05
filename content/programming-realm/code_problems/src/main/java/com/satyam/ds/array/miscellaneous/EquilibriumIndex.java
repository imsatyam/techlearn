package com.satyam.ds.array.miscellaneous;

/**
    Sum of elements at lower index = sum of elements at higher index
 */

public class EquilibriumIndex {

    private static int getEquilibriumIndex(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }

        int leftSum = 0;
        for (int index = 0; index < arr.length; index++) {
            sum = sum - arr[index];
            if (leftSum == sum) {
                return  index;
            }
            leftSum += arr[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Equilibrium index is " + getEquilibriumIndex(arr));
    }
}
