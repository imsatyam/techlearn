package com.satyam.algorithm.dynamicprogramming;

public class LongestCommonSubsequence {

    private static int lcs(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[][] arr = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                }

                else if (arr1[i - 1] == arr2[j - 1]) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }

                else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[len1 - 1][len2 - 1];
    }

}
