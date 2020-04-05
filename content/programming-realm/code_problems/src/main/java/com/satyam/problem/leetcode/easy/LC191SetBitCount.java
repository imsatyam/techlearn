package com.satyam.problem.leetcode.easy;

/**

 LC #191
 Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

 Input: 00000000000000000000000000001011
 Output: 3


 Idea:
     Number of 1 bits is also called Hamming weight.
     1. Integer.bitCount(n);
     2. Brian Kernighan’s algorithm."

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286676711/
    Runtime: 1 ms
    Memory: 33.3 MB
 */

public class LC191SetBitCount {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }

        int result = 0, size = 32;
        for (int i = 0; i < size; i++) {
            result += n & 1;
            n >>= 1;
        }

        return result;
    }
}
