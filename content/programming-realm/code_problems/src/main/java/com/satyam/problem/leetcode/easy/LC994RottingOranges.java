package com.satyam.problem.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**

 LC #994
 In a given grid, each cell can have one of three values:

 - the value 0 representing an empty cell;
 - the value 1 representing a fresh orange;
 - the value 2 representing a rotten orange.

 Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 Idea:
    Add all the rotten oranges to the queue.
    One by one process all the neighbours of each of the elements in queue.
    Increment time count only once at each level.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/288994827/
    Runtime: 2 ms
    Memory: 39.6 MB

 */

public class LC994RottingOranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int totalTime = 0;
        Queue<Node> queue = new LinkedList<>();
        Count count = new Count();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Node(i, j));
                } else if (grid[i][j] == 1) {
                    count.fresh++;
                }
            }
        }

        if (count.fresh == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            boolean avoidIncrement = false;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.poll();
                boolean left = makeNeighbourRotten(grid, node.x, node.y - 1, queue, count);
                boolean right = makeNeighbourRotten(grid, node.x, node.y + 1, queue, count);
                boolean top = makeNeighbourRotten(grid, node.x - 1, node.y, queue, count);
                boolean bottom = makeNeighbourRotten(grid, node.x + 1, node.y, queue, count);
                if (!avoidIncrement && (left || right || top || bottom)) {
                    avoidIncrement = true;
                    totalTime++;
                }
            }
        }
        return count.fresh != 0 ? -1 : totalTime;
    }

    private boolean makeNeighbourRotten(int[][] grid, int row, int col, Queue<Node> queue, Count count) {
        if (!isValidCell(row, col, grid) || grid[row][col] != 1) {
            return false;
        }
        grid[row][col] = 2;
        count.fresh--;
        queue.add(new Node(row, col));
        return true;
    }

    private boolean isValidCell(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Count {
        int fresh = 0;
    }
}
