package com.satyam.problem.leetcode.medium;

/**

 LC #209
 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
 If there isn't one, return 0 instead.

 Example:

 Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 Follow up:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

 Idea:
 Iterate, keep track of sum.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291472414/
    Runtime: 1 ms
    Memory: 36.7 MBs

 */

public class LC209MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

}
