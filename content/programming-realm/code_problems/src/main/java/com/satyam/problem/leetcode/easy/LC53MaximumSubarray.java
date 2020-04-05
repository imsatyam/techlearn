package com.satyam.problem.leetcode.easy;

/**

 LC #53
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 Idea:
    Modified Kadane's algorithm

 Submission Detail
    Link: https://leetcode.com/submissions/detail/310101581/
    Runtime: 0 ms
    Memory: 41.7 MB

 */

public class LC53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

}
