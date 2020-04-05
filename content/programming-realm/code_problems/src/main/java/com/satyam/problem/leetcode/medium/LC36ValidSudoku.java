package com.satyam.problem.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**

 LC #36
 Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 Idea:
 Valid row, valid column, valid box?

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286634584/
    Runtime: 3 ms
    Memory: 42.5 MB

 */

public class LC36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        if (hasValidCells(board) && hasValidBoxes(board)) {
            return true;
        }

        return false;
    }

    private boolean hasValidCells(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> rowValues = new HashSet<>();
            Set<Character> colValues = new HashSet<>();
            for(int col = 0; col < board[row].length; col++) {
                if (!isValid(board, row, col, rowValues)
                        || !isValid(board, col, row, colValues)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasValidBoxes(char[][] board) {
        int rowMax = board.length, colMax = board[0].length, limit = (int)Math.sqrt(rowMax);
        int row = 0, col = 0;
        int[] countArr;
        while(row != rowMax && col != colMax) {
            countArr = new int[rowMax];
            for (int r = row; r < row + limit; r++) {
                for (int c = col; c < col + limit; c++) {
                    if (board[r][c] != '.') {
                        int currVal = ++countArr[(board[r][c] - '0') - 1];
                        if (currVal > 1) {
                            return false;
                        }
                    }
                }
            }
            col = col + limit;
            if (col == colMax) {
                row = row + limit;
                col = 0;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, Set<Character> values){
        if (board[row][col] != '.') {
            if (values.contains(board[row][col])) {
                return false;
            }
            values.add(board[row][col]);
        }
        return true;
    }

}
