package com.satyam.algorithm.backtracking;

/**

 In this variation, Rat is allowed to jump multiple steps at a time instead of 1.

 Input :
 {
     {2, 1, 0, 0},
     {3, 0, 0, 1},
     {0, 1, 0, 1},
     {0, 0, 0, 1}
 }

 Output :
 {
     {1, 0, 0, 0},
     {1, 0, 0, 1},
     {0, 0, 0, 1},
     {0, 0, 0, 1}
 }

 Explanation:
 Rat started with M[0][0] and can jump upto 2 steps right/down.
 Let's try in horizontal direction -
 M[0][1] won't lead to solution and M[0][2] is 0 which is dead end.
 So, backtrack and try in down direction.
 Rat jump down to M[1][0] which eventually leads to solution.

 */


public class RatInMazeProblemWithMultipleJumpsAllowed {

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

        if (isSafe(maze, row, col)) {
            sol[row][col] = 1;
            for (int i = 1; i <= maze[row][col] && i < N; i++) {                          // <- change from the actual problem
                if (hasReachedDestination(maze, sol, row + i, col)) {
                    return true;
                }
                if (hasReachedDestination(maze, sol, row, col + i)) {
                    return true;
                }
            }
            sol[row][col] = 0;
        }
        return false;
    }


    private static boolean isSafe(int[][] maze, int row, int col) {
        return row >= 0 && row < N
                && col >= 0 && col < N
                && maze[row][col] != 0;             // <- condition different from original
    }



    public static void main(String[] args) {
        int maze[][] = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
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
