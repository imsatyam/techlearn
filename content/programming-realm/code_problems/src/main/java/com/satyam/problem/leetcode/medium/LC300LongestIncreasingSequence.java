package com.satyam.problem.leetcode.medium;

import java.util.Arrays;

/**

 LC #300
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:

 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 Note:

 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.

 Idea:
    Use DP

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291772751/
    Runtime: 19 ms
    Memory: 37.1 MB

 */

public class LC300LongestIncreasingSequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] lis = new int[n];

        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int x : lis) {
            max = Math.max(x, max);
        }
        return max;
    }

}
