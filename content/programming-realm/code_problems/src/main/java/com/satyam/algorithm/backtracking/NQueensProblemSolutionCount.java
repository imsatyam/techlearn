package com.satyam.algorithm.backtracking;

/**

 LeetCode #52 [Hard]
 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 Example:
 Input: 4
 Output: 2
 Explanation: There exist two distinct solutions to the 4-queens puzzle as shown below.
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 Complexity:
 number of possible arrangements of N Queens on N x N chessboard is 𝑁!, given you are skipping row or column, already having a queen placed.

 Best, Average, Worst complexity: 𝑂(𝑁!)

 */

public class NQueensProblemSolutionCount {

    private static final int N = 4;

    /**
     * Main function
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int resultCount = solution.totalNQueens(N);
        System.out.println("Possible number of solutions: " + resultCount);
    }

    /**
     * Implementation of the class
     */
    static class Solution {
        public int totalNQueens(int n) {
            if (n <= 0) {
                return 0;
            }

            Result result = new Result();
            solveNQueens(n, getBoard(n), 0, result);
            return result.possibleSolutions;
        }

        private void solveNQueens(int n, int[][] board, int col, Result result) {
            if (col == n) {
                result.possibleSolutions++;
                return;
            }

            for (int r = 0; r < n; r++) {
                if (isSafe(n, board, r, col)) {
                    board[r][col] = 1;
                    solveNQueens(n, board, col + 1, result);
                    board[r][col] = 0;
                }
            }
            return;
        }


        private boolean isSafe(int n, int[][] board, int row, int col) {

            int i, j;

            for (i = 0; i < col; i++) {
                if (board[row][i] == 1) {
                    return false;
                }
            }

            for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            for (i = row, j = col; i < n && j >= 0; i++, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            return true;
        }

        private int[][] getBoard(int n) {
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = 0;
                }
            }
            return board;
        }
    }

    static class Result {
        int possibleSolutions = 0;
    }

}
