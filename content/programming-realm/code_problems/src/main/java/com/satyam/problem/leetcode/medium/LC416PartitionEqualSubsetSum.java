package com.satyam.problem.leetcode.medium;

/**

 LC #416
 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such
 that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.


 Example 1:
 Input: [1, 5, 11, 5]
 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].

 Idea:
    Use Dynamic programming

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277933344/
    Runtime: 11 ms
    Memory: 36.7 MB

 */

public class LC416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        total /= 2;

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = total; j >= 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }
        return dp[total];
    }

}
