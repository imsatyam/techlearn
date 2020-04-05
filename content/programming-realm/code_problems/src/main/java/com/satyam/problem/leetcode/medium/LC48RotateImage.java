package com.satyam.problem.leetcode.medium;

/**

 LC #48
 You are given an n x n 2D matrix representing an image.
 Rotate the image by 90 degrees (clockwise).
 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

 Idea:
 Do matrix transpose and then swap elements in the row.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286657921/
    Runtime: 0 ms
    Memory: 36.2 MB

 */

public class LC48RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int r = 0, c = 0, temp = 0;

        // transpose
        for (r = 0; r < matrix.length; r++) {
            for (c = r + 1; c < matrix[r].length; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // now swap from left and right and manage pointers
        for (r = 0; r < matrix.length; r++) {
            int left = 0, right = matrix[r].length - 1;
            while(left < right) {
                temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;
                left++;
                right--;
            }
        }
    }

}
