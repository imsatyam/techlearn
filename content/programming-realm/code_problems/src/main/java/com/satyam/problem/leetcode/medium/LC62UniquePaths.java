package com.satyam.problem.leetcode.medium;

/**

 LC #62
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 Example:
 Input: m = 3, n = 2
     Output: 3
     Explanation:
     From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     1. Right -> Right -> Down
     2. Right -> Down -> Right
     3. Down -> Right -> Right


 Idea:
    Use dynamic Programming

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308956047/
    Runtime: 0 ms
    Memory: 36.6 MB

 */

public class LC62UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        int i = 0, j = 0;

        for (i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
