package com.satyam.problem.leetcode.easy;

/**

 LC #88
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

 Idea:
    Start merging in descending order.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277248035/
    Runtime: 0 ms
    Memory: 36.4s MB

 */

public class LC88MergeSorterArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0 && n == 0) {
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
