package com.satyam.problem.leetcode.medium;

/**

 LC #695
 Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:

 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

 Idea:
    Use DFS

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308624994/
    Runtime: 2 ms
    Memory: 41.3 MB

 */

public class LC695MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null && grid.length == 0) {
            return 0;
        }

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(grid, r, c, seen));
            }
        }
        return ans;
    }

    private int area(int[][] grid, int r, int c, boolean[][] seen) {
        if (r < 0 || r >= grid.length
                || c < 0 || c >= grid[0].length
                || grid[r][c] != 1
                || seen[r][c]) {
            return 0;
        }
        seen[r][c] = true;
        return (1
                + area(grid, r + 1, c, seen)
                + area(grid, r - 1, c, seen)
                + area(grid, r, c + 1, seen)
                + area(grid, r, c - 1, seen));
    }

}
