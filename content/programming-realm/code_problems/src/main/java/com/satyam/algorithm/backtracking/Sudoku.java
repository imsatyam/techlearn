package com.satyam.algorithm.backtracking;

/**

 Given a partially filled 9×9 2D array ‘grid[9][9]’,
 the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column, and subgrid of size 3×3
 contains exactly one instance of the digits from 1 to 9.

 */

public class Sudoku {

    private static final int N = 9;

    private static boolean isSudokuSolved(int[][] board) {
        Cell emptyCell = getEmptyCell(board);
        if (null == emptyCell) {
            return true;
        }

        // try all values in empty cell starting from 1 to n (inclusive)
        for (int num = 1; num <= N; num++) {
            if (isSafe(board, emptyCell, num)) {
                board[emptyCell.row][emptyCell.col] = num;
                if (isSudokuSolved(board)) {
                    return true;
                }
                board[emptyCell.row][emptyCell.col] = 0;
            }
        }
        return false;
    }


    private static boolean isSafe(int[][] board, Cell emptyCell, int num) {

        // row has unique value
        for (int col = 0; col < N; col++) {
            if (board[emptyCell.row][col] == num) {
                return false;
            }
        }

        // column has unique value
        for (int row = 0; row < N; row++) {
            if (board[row][emptyCell.col] == num) {
                return false;
            }
        }

        // Small square box has unique value
        int sqrt = (int) Math.sqrt(N);
        int boxRowStart = emptyCell.row - emptyCell.row % sqrt;
        int boxColStart = emptyCell.col - emptyCell.col % sqrt;

        for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
            for (int j = boxColStart; j < boxColStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private static Cell getEmptyCell(int[][] board) {
        int i = 0, j = 0;
        boolean isEmpty = false;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    isEmpty = true;
                    break;
                }
            }

            if (isEmpty) {
                break;
            }
        }

        if (!isEmpty) {
            return null;
        }
        return new Cell(i, j);
    }

    static class Cell {
        private final int row;
        private final int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        if (isSudokuSolved(board)) {
            printSolution(board);
        } else {
            System.out.println("Could not solve sudoku challenge...");
        }
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
