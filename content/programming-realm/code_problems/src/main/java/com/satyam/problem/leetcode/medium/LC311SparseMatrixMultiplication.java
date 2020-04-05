package com.satyam.problem.leetcode.medium;

/**

 LC #311
 Given two sparse matrices A and B, return the result of AB.
 You may assume that A's column number is equal to B's row number.
 Example:
 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |     | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 |  x  | 0 0 0 | = | -7 0 3 |
                     | 0 0 1 |

 Idea:
    - Create product matrix. Iterate through it and calculate result for each position. This ignores the fact that the matrices are sparse.
    - For sparse matrix, Instead of iterating through the product matrix, I can iterate through A, and add the contribution
        of each number to the result matrix. If A[i][j] == 0, we can just skip the calculation.

 Submission Detail
    - NA -

 */

public class LC311SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int aRow = A.length;
        int aColumn = A[0].length;
        int bRow = B.length;
        int bColumn = B[0].length;

        int[][] product = new int[aRow][bColumn];
        
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < aColumn; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < bColumn; k++) {
                    product[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return product;
    }

}
