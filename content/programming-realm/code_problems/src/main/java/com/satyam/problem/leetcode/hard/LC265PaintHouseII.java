package com.satyam.problem.leetcode.hard;

/**

 LC #265
 There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
 with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0]
 is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.
 Follow up:
 Could you solve it in O(nk) runtime?

 Idea:
     Sub-problem: find the minimum cost to paint houses up to current house.
     Function: f[i][j] = min(f[i - 1][k] where k != j) + costs[i][j].
     Initialization: modify the costs matrix directly.
     Answer: min(f[costs.length][j]).

 Currently this solution takes O(nk^2). Iterating all combinations takes O(nk). Finding the minimum among colors takes O(k).
 The optimization here is to reduce finding minimum to O(1). I do not need to find minimum for every color,
 because all I need is the minimum and the next minimum. If current color is the same as the previous color,
 which happens to have the minimum cost, I can just use the second minimum.


 Submission Detail
    NA

 Reference
 http://buttercola.blogspot.com/2015/09/leetcode-paint-house-ii.html

 */

public class LC265PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        // dp[j] means the min cost for color j
        int[] dp = new int[k];
        int min1 = 0;
        int min2 = 0;

        for (int i = 0; i < n; i++) {
            int oldMin1 = min1;
            int oldMin2 = min2;

            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (dp[j] != oldMin1 || oldMin1 == oldMin2) {
                    dp[j] = oldMin1 + costs[i][j];
                } else {
                    dp[j] = oldMin2 + costs[i][j];
                }

                if (min1 <= dp[j]) {
                    min2 = Math.min(min2, dp[j]);
                } else {
                    min2 = min1;
                    min1 = dp[j];
                }
            }

        }

        return min1;
    }

}
