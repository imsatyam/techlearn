package com.satyam.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**

 LeetCode #51 [Hard]
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen
 and an empty space respectively.

 Example:
 Input: 4
 Output: [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


 Complexity:
 number of possible arrangements of N Queens on N x N chessboard is 𝑁!, given you are skipping row or column, already having a queen placed.

 Best, Average, Worst complexity: 𝑂(𝑁!)

 */

public class NQueensProblemAllSolution {

    private static final int N = 4;

    /**
     * Main function
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> results = solution.solveNQueens(N);
        if (results.isEmpty()) {
            System.out.println("No solution...");
        } else {
            int i = 1;
            for (List<String> result : results) {
                System.out.println("====== Solution " + i + " ======");
                for (String row : result) {
                    System.out.println(row);
                }
                i++;
                System.out.println();
            }
        }
    }

    /**
     * Implementation of the class
     */
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions = new ArrayList<>();
            if (n <= 0) {
                return solutions;
            }

            char[][] board = getBoard(n);
            solveNQueens(n, board, 0, solutions);
            return solutions;
        }

        private void solveNQueens(int n, char[][] board, int currCol, List<List<String>> solutions) {

            if (currCol == n) {
                addSolution(board, solutions);
                return;
            }

            for (int row = 0; row < n; row++) {
                if (isSafe(n, board, row, currCol)) {
                    board[row][currCol] = 'Q';
                    solveNQueens(n, board, currCol + 1, solutions);
                    board[row][currCol] = '.';
                }
            }
            return;
        }

        private boolean isSafe(int n, char[][] board, int row, int currCol) {
            int i, j;

            // check this row on left
            for (i = 0; i < currCol; i++) {
                if (board[row][i] == 'Q') {
                    return false;
                }
            }

            // check upper diagonal i.e. i++ and j--
            for (i = row, j = currCol; i < n && j>= 0; i++, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            // check lower diagonal i.e. i-- and j--
            for (i = row, j = currCol; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }

        private void addSolution(char[][] board, List<List<String>> solutions) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }
            solutions.add(solution);
        }

        private char[][] getBoard(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            return board;
        }
    }

}
