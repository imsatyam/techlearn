package com.satyam.problem.leetcode.easy;

/**

 LC #190
 Input: 00000010100101000001111010011100
 Output: 00111001011110000010100101000000

 Idea:
     For problem: Input: 00110, Expected output: 01100

     Approach:

     To get a bit from the given number
     ==================================
     0 & 1 = 0, 1 & 1 = 1,  => When we want original data we use & 1,
     This can be used to get the bit.

     00110 & 1 => 0, right shift 00110
     0011  & 1 => 1, right shift 0011


     To add a bit to the result
     ==========================
     Say we have 101. Now to add a bit,
     - first we need to shift left to make space => 1010
     - now OR it with the bit that we want to add i.e. 1010 | 1 = 1011

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277221258/
    Runtime: 0 ms
    Memory: 36.8 MB

 Reference
    https://www.youtube.com/watch?v=KE5Axm7uzok

 */

public class LC190ReverseBits {

    public int reverseBits(int n) {

        if (n == 0) {
            return 0;
        }

        int result = 0, times = 32;

        while (times > 0) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
            times--;
        }

        return result;
    }

}
