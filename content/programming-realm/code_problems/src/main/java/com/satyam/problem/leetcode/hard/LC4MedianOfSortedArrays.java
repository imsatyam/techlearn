package com.satyam.problem.leetcode.hard;

/**

 LC #4
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Idea:
    Brute force: Use merge process of merge sort
    Better Idea: Utilize the fact that the arrays are sorted and therefore apply partition.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277290227/
    Runtime: 2 ms
    Memory: 39.5 MB

 Reference:
    https://www.youtube.com/watch?v=LPFhl65R7ww

 */

public class LC4MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] smallArr = null, largeArr = null;
        if (nums1.length <= nums2.length) {
            smallArr = nums1;
            largeArr = nums2;
        } else {
            smallArr = nums2;
            largeArr = nums1;
        }

        // Traverse smaller array to get a partition using binary search
        int l1 = smallArr.length, l2 = largeArr.length, low = 0, high = l1;
        while (low <= high) {

            int partition1 = (low + high) / 2;
            int partition2 = ((l1 + l2 + 1) / 2) - partition1;

            int leftMax1 = (partition1 == 0) ? Integer.MIN_VALUE : smallArr[partition1 - 1];
            int rightMin1 = (partition1 == l1) ? Integer.MAX_VALUE : smallArr[partition1];

            int leftMax2 = (partition2 == 0) ? Integer.MIN_VALUE : largeArr[partition2 - 1];
            int rightMin2 = (partition2 == l2) ? Integer.MAX_VALUE : largeArr[partition2];

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if ((l1 + l2) % 2 == 0) {
                    return ((double)Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2;
                }
                return (double)Math.max(leftMax1, leftMax2);
            } else if (leftMax1 > rightMin2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return -1;
    }

}
