package com.satyam.problem.leetcode.easy;

/**

 LC #256
 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 The cost of painting each house with a certain color is different. You have to paint all the houses such
 that no two adjacent houses have the same color.
 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0]
 is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
 Find the minimum cost to paint all houses.

 Input: [[17,2,17],[16,16,5],[14,3,19]]
 Output: 10
 Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 Minimum cost: 2 + 5 + 3 = 10.

 Note:
 All costs are positive integers.

 Idea:
 Focus on minimum cost

 Submission Detail
    - NA -

 Reference:
    https://www.youtube.com/watch?v=fZIsEPhSBgM

 */

public class LC256PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int last = costs.length - 1;
        return Math.min(costs[last][0], Math.min(costs[last][1], costs[last][2]));
    }
}
