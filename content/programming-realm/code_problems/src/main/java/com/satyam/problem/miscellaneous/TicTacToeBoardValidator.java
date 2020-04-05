package com.satyam.problem.miscellaneous;

/**

 Given a board,

    if O is winning
        Check if X is also winning => invalid
        check if count(0) != count(x) => invalid

    if x is winning
        check if count(x) != count(0) + 1 => invalid

 */
public class TicTacToeBoardValidator {

    private static final int[][] TIC_TAC_TOE_WINNING_COMBINATIONS = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 1, 8},
            {2, 4, 6}
    };

    private static boolean isWinning(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (TIC_TAC_TOE_WINNING_COMBINATIONS[i][0] == c
                    && TIC_TAC_TOE_WINNING_COMBINATIONS[i][1] == c
                    && TIC_TAC_TOE_WINNING_COMBINATIONS[i][2] == c) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidTicTacToeBoard(char[] board) {

        int xCount = 0;
        int oCount = 0;

        for (char c : board) {
            if (c == 'X') {
                xCount++;
            } else if (c == 'O') {
                oCount++;
            }
        }

        if (xCount == oCount || xCount == (oCount + 1)) {

            if (isWinning(board, 'O')) {
                if (isWinning(board, 'X')) {
                    return false;
                }
                return xCount == oCount;
            }

            if (isWinning(board, 'X')) {
                return xCount == oCount;
            }
        }

        return false;
    }
}
