package com.satyam.algorithm.backtracking;

/**

 Given a maze represented by following matrix, find a path from source (0, 0) to destination (N-1, N-1)

 {1, 0, 0, 0}
 {1, 1, 0, 1}
 {0, 1, 0, 0}
 {1, 1, 1, 1}

 */


public class RatInMazeProblem {

    private static final int N = 4;

    private static void solveRatInMazeProblem(int[][] maze) {
        int[][] sol = new int[N][N];                            // <- create a separate solution mtx
        if (hasReachedDestination(maze, sol, 0, 0)) {
            printSolution(sol);
        } else {
            System.out.println("Could not reach destination...");
        }
    }

    private static boolean hasReachedDestination(int[][] maze, int[][] sol, int row, int col) {

        if (row == N - 1 && col == N - 1) {
            sol[row][col] = 1;
            return true;
        }

        if (isSafe(maze, row, col)) {               // <- is safe
            sol[row][col] = 1;
            if (hasReachedDestination(maze, sol, row + 1, col)) {
                return true;
            }
            if (hasReachedDestination(maze, sol, row, col + 1)) {
                return true;
            }
            sol[row][col] = 0;
        }
        return false;
    }


    private static boolean isSafe(int[][] maze, int row, int col) {
        return row >= 0 && row < N
                && col >= 0 && col < N
                && maze[row][col] == 1;
    }



    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        solveRatInMazeProblem(maze);
    }

    private static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
