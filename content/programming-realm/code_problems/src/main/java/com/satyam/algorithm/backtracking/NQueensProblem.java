package com.satyam.algorithm.backtracking;

/**

The expected output is a binary matrix which has 1s for the blocks where queens are placed.
For example, following is the output matrix for above 4 queen solution:

              { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}
 */

public class NQueensProblem {

    private static final int N = 4;

    private static boolean isNQueensProblemSolved(int[][] board, int currCol) {

        if (currCol >= N) {
            return true;
        }

        // for each row -> try placing queen in the currCol
        for (int row = 0; row < N; row++) {

            if (isSafe(board, row, currCol)) {      // <----- isSafe method is important
                board[row][currCol] = 1;
                if (isNQueensProblemSolved(board, currCol + 1)) {
                    return true;
                }
                board[row][currCol] = 0;            // backtracking
            }
        }
        return false;
    }


    private static boolean isSafe(int[][] board, int row, int currCol) {

        int i, j;

        // check this row on left
        for (i = 0; i < currCol; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check upper diagonal i.e. i++ and j--
        for (i = row, j = currCol; i < N && j>= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal i.e. i-- and j--
        for (i = row, j = currCol; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int [][] board = new int[][] {
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0}
        };

        if (isNQueensProblemSolved(board, 0)) {
            printSolution(board);
        } else {
            System.out.println("Could not find a solution...");
        }

    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
