package com.satyam.problem.leetcode.easy;

/**

 LC #69
 Implement int sqrt(int x).
 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned

 Idea:
    Use binary search. If not a perfect square, return the nearest square-root

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286659303/
    Runtime: 1 ms
    Memory: 33.4 MB

 */

public class LC69SqrtOfX {

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        // use binary search
        int left = 0, right = x, mid = 0;
        while (left <= right) {

            mid = left + (right - left) / 2;
            if (mid > x/mid) {
                right = mid;
            } else {
                // not a perfect square, return the nearest perfect square.
                if ( (mid + 1) > x / (mid + 1) ) {
                    return mid;
                }
                left = mid;
            }
        }

        return -1;
    }

}
