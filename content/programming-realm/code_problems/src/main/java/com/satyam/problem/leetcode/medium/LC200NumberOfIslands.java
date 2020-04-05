package com.satyam.problem.leetcode.medium;

/**

 LC #200
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
 is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:
 Input:
 11110
 11010
 11000
 00000

 Output: 1

 Example 2:
 Input:
 11000
 11000
 00100
 00011

 Output: 3

 Idea:
    Classic graph problem

 Submission Detail
    Link: https://leetcode.com/submissions/detail/278776852/
    Runtime: 2 ms
    Memory: 40.8 MB

 */

public class LC200NumberOfIslands {

    private static final int[][] NEIGHBOURS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        int islandCount = 0;
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < NEIGHBOURS.length; i++) {
            int nextRow = row + NEIGHBOURS[i][0];
            int nextCol = col + NEIGHBOURS[i][1];
            if (isSafe(grid, nextRow, nextCol, visited)) {
                dfs(grid, nextRow, nextCol, visited);
            }
        }
    }

    private boolean isSafe(char[][] grid, int row, int col, boolean[][] visited) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && grid[row][col] == '1'
                && !visited[row][col];
    }

}
