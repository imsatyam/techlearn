package com.satyam.ds.array.miscellaneous;

/**

 Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has
 the largest sum.
 {-2, -3, 4, -1, -2, 1, 5, -3}

 4 + (-1) + (-2) + 1 + 5 = 7 (Max contiguous array sum)

 Kadane's algorithm

 def max_subarray(A):
     max_ending_here = max_so_far = A[0]
     for x in A[1:]:
         max_ending_here = max(x, max_ending_here + x)
         max_so_far = max(max_so_far, max_ending_here)
     return max_so_far

 */
public class LargestSumContiguousArray {

    private static int getMaxContiguousArraySum(int[] arr) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int el : arr) {
            maxEndingHere += el;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            } else if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Max Contiguous array sum is: " + getMaxContiguousArraySum(arr));
    }

}
