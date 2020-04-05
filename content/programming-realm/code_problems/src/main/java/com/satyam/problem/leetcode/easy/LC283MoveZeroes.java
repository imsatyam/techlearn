package com.satyam.problem.leetcode.easy;

/**

 LC #289
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 Idea:
    Copy non zero elements first and then fill zeroes

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277066207/
    Runtime: 0 ms
    Memory: 38.3 MB

 */

public class LC283MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }

        while(j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

}
