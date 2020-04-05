package com.satyam.problem.leetcode.hard;

/**

 LC #85
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 Example:
 Input:
 [
     ["1","0","1","0","0"],
     ["1","0","1","1","1"],
     ["1","1","1","1","1"],
     ["1","0","0","1","0"]
 ]
 Output: 6

 Idea:
    - Can be solved in two ways
        - Use LC84LargestRectangleInHistogram to calculate area in each row.
            Reference: https://www.youtube.com/watch?v=g8bSdXCG-lA

        - Use dynamic programming by transforming input array (in left) into dp array (in right)
             1 0 1 0 0      1 0 1 0 0
             1 0 1 1 1  =>  2 0 2 1 1
             1 1 1 1 1  =>  3 1 3 2 2
             1 0 0 1 0      4 0 0 3 0


 Submission Detail (Histogram approach)
    Link: https://leetcode.com/submissions/detail/291737019/
    Runtime: 26 ms
    Memory: 43.2 MB

 Submission Detail (DP approach)
     Link: https://leetcode.com/submissions/detail/291739917/
     Runtime: 8 ms
     Memory: 42.5 MB

 */

public class LC85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? (dp[i - 1][j] + 1) : 0;
                }

                int min = dp[i][j];
                for (int k = j; k >= 0; k--) {
                    if (min == 0) {
                        break;
                    }
                    if (dp[i][k] < min) {
                        min = dp[i][k];
                    }
                    maxArea = Math.max(maxArea, min * (j - k + 1));
                }
            }
        }

        return maxArea;
    }
}
