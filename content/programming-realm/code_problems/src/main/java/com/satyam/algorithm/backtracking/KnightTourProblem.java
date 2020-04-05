package com.satyam.algorithm.backtracking;

/**

 The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.

 */

public class KnightTourProblem {

    private static final int N = 8;

    private static void solveKnightTourProblem() {

        //  Create solution matrix
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // Possible moves for knight on chess board
        int xMoves[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMoves[] = {1, 2, 2, 1, -1, -2, -2, -1};

        board[0][0] = 0;

        if (hasCompletedTour(board, xMoves, yMoves, 0, 0, 1)) {
            printSolution(board);
        } else {
            System.out.println("Could not complete tour...");
        }
    }


    private static boolean hasCompletedTour(int[][] board, int[] xMoves, int[] yMoves,
                                            int row, int col, int moveCount) {

        if (moveCount == N * N) {
            return true;
        }

        // try all possible moves from current coordinates.
        for (int k = 0; k < 8; k++) {
            int nextRow = row + xMoves[k];
            int nextCol = col + yMoves[k];
            if (isSafe(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = moveCount;
                if (hasCompletedTour(board, xMoves, yMoves, nextRow, nextCol, moveCount + 1)) {
                    return true;
                }
                board[nextRow][nextCol] = -1;
            }
        }
        return false;
    }


    private static boolean isSafe(int[][] board, int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < N
                && nextCol >= 0 && nextCol < N
                && board[nextRow][nextCol] == -1;
    }


    public static void main(String[] args) {
        solveKnightTourProblem();
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
