package com.satyam.problem.leetcode.medium;

/**

 LC #221
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:
 Input:
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4

 Idea:
    Use dp

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286708566/
    Runtime: 4 ms
    Memory: 39.7 MB

 */

public class LC221MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length; int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int maxSquareLen = 0, prev = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSquareLen = Math.max(maxSquareLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSquareLen * maxSquareLen;
    }

}
