package com.satyam.problem.leetcode.medium;

/**

 LC #240
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
  - Integers in each row are sorted in ascending from left to right.
  - Integers in each column are sorted in ascending from top to bottom.

 Idea:
     Start searching from first row last column and go in a direction based on comparision of target with cell value

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286674394/
    Runtime: 5 ms
    Memory: 41.8 MB

 */

public class LC240SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int currRow = 0, currCol = n - 1;

        while (currRow < m && currCol >= 0) {
            if (matrix[currRow][currCol] == target) {
                return true;
            }

            if (matrix[currRow][currCol] > target) {
                currCol--;
            } else {
                currRow++;
            }
        }
        return false;
    }

}
