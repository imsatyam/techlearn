package com.satyam.problem.leetcode.medium;

import java.util.Arrays;

/**

 LC #775
 The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

 The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

 Return true if and only if the number of global inversions is equal to the number of local inversions.

 Example 1:
 Input: A = [1,0,2]
 Output: true
 Explanation: There is 1 global inversion, and 1 local inversion.
 Example 2:

 Input: A = [1,2,0]
 Output: false
 Explanation: There are 2 global inversions, and 1 local inversion.

 Idea:
    Merge Sort can be used for global inversion

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277927779/
    Runtime: 22 ms
    Memory: 41.6 MB

 */

public class LC775GlobalAndLocalInversions {

    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        int localInversions = getLocalInversionCount(A);
        int globalInversions = getGlobalInversions(A, 0, A.length - 1);
        return localInversions == globalInversions;
    }

    private int getLocalInversionCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                count++;
            }
        }
        return count;
    }

    private int getGlobalInversions(int[] a, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += getGlobalInversions(a, low, mid);
            count += getGlobalInversions(a, mid + 1, high);
            count += getInversionsOnMerge(a, low, mid, high);
        }
        return count;
    }

    private int getInversionsOnMerge(int[] a, int low, int mid, int high) {

        int[] lArr = Arrays.copyOfRange(a, low, mid + 1);
        int[] rArr = Arrays.copyOfRange(a, mid + 1, high + 1);

        int i = 0, j = 0, k = low, count = 0;
        while (i < lArr.length && j < rArr.length) {
            if (lArr[i] <= rArr[j]) {
                a[k++] = lArr[i++];
            } else {
                a[k++] = rArr[j++];
                count += (mid + 1) - (low + i);
            }
        }

        while (i < lArr.length) {
            a[k++] = lArr[i++];
        }

        while (j < rArr.length) {
            a[k++] = rArr[j++];
        }

        return count;
    }

}
