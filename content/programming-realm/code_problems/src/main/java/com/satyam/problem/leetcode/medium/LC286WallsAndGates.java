package com.satyam.problem.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**

 LC #286
 You are given a m x n 2D grid initialized with these three possible values.
 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 Idea:
 Iterate through the grid. Add gates' coordinates to queue. BFS from gates and expand through all rooms.

 Submission Details
    - NA -

 Reference:
    https://www.youtube.com/watch?v=Pj9378ZsCh4

 */

public class LC286WallsAndGates {

    private final int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{ i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] room = queue.poll();
            int distance = rooms[room[0]][room[1]];

            for (int i = 0; i < 4; i++) {
                int row = room[0] + DIRECTIONS[i][0];
                int column = room[1] + DIRECTIONS[i][1];

                if (row >= 0 && row < rooms.length && column >= 0 && column < rooms[0].length) {
                    if (rooms[row][column] == Integer.MAX_VALUE) {
                        rooms[row][column] = distance + 1;
                        queue.offer(new int[]{ row, column });
                    }
                }
            }
        }
    }

}
