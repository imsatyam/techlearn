package com.satyam.problem.leetcode.medium;

/**

 LC #79
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Example:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.

 Idea:
    At each index do dfs on neighbours

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279230567/
    Runtime: 4 ms
    Memory: 38.2 MB

 */

public class LC79WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(count)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = ' ';
        boolean isFound = dfs(board, row + 1, col, count + 1, word)
                || dfs(board, row - 1, col, count + 1, word)
                || dfs(board, row, col + 1, count + 1, word)
                || dfs(board, row , col - 1, count + 1, word);
        board[row][col] = temp;
        return isFound;
    }

}
