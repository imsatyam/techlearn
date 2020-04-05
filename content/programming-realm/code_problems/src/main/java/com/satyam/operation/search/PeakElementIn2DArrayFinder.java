package com.satyam.operation.search;

/**

 1. Consider mid column and find maximum element in it.
 2. Let index of mid column be ‘mid’, value of maximum element in mid column be ‘max’ and maximum element be at ‘mat[rowIndex][mid]’.
 3. If max >= A[index][mid-1] & max >= A[index][mid +1], max is a peak, return max.
 4. If max < mat[max_index][mid-1], recur for left half of matrix.
 5.     If max < mat[max_index][mid+1], recur for right half of matrix.

 */

public class PeakElementIn2DArrayFinder {

    private static int findPeakElement(int[][] arr) {
        return findPeakElement(arr, arr.length, arr[0].length, arr[0].length / 2);
    }

    private static int findPeakElement(int[][] arr, int rows, int columns, int midCol) {
        MaxEntry maxEntry = getMaxEntry(arr, rows, midCol);
        if (midCol == 0 || midCol == columns - 1) {
            return maxEntry.val;
        }

        if (maxEntry.val >= arr[maxEntry.row][midCol - 1] && maxEntry.val >= arr[maxEntry.row][midCol + 1]) {
            return maxEntry.val;
        }

        if (maxEntry.val < arr[maxEntry.row][midCol - 1]) {
            return findPeakElement(arr, rows, columns, midCol - midCol/2);
        }

        return findPeakElement(arr, rows, columns, midCol + midCol/2);
    }

    private static MaxEntry getMaxEntry(int[][] arr, int rows, int midCol) {
        MaxEntry maxEntry = new MaxEntry();
        for (int r = 0; r < rows; r++) {
            if (arr[r][midCol] > maxEntry.val) {
                maxEntry.row = r;
                maxEntry.col = midCol;
                maxEntry.val = arr[r][midCol];
            }
        }
        return maxEntry;
    }

    public static void main(String[] args) {
        int[][] arr = {{ 10, 8, 10, 10 },
                { 14, 13, 12, 11 },
                { 15, 9, 11, 21 },
                { 16, 17, 19, 20 }};
        int peak = findPeakElement(arr);
        if (peak != -1) {
            System.out.println("Found: " + peak);
        } else {
            System.out.println("Not Found");
        }
    }

    static class MaxEntry {
        int row;
        int col;
        int val;

        public MaxEntry(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public MaxEntry() {
        }
    }
}
