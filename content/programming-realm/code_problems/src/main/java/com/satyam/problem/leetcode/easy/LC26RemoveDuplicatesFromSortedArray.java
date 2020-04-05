package com.satyam.problem.leetcode.easy;

/**

 LC #26
 Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Idea:
    - Use two pointers i and j where i represents iteration index while j represents last non-duplicate element.
    - loop must run from 0 to n-2 as we are comparing values at index i and i + 1

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277113033/
    Runtime: 1 ms
    Memory: 39.8 MB

 */

public class LC26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j++] = nums[nums.length - 1];
        return j;
    }

}
