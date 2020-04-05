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
     Link: https://leetcode.com/submissions/detail/277109161/
     Runtime: 0 ms
     Memory: 33.3 MB

 */

public class LC191SetBitCountUsingLookupMethod {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        return Integer.bitCount(n);
    }
}
