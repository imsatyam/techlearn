package com.satyam.problem.leetcode.easy;

/**

 LC #7
 Given a 32-bit signed integer, reverse digits of an integer.

 Idea:
    Handle negative and overflow

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286624654/
    Runtime: 1 ms
    Memory: 33.6 MB

 */

public class LC7ReverseInteger {

    public int reverse(int x) {
        
        if (x == 0) {
            return 0;
        }
        
        boolean isMinus = x < 0;
        if (isMinus) {
            x = x * -1;
        }
        
        long reversedValue = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            reversedValue = reversedValue * 10 + lastDigit;
            x = x / 10;
        }
        
        if (isMinus) {
            reversedValue = reversedValue * -1;
        }
        
        if (reversedValue > Integer.MAX_VALUE || reversedValue < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int)reversedValue;   
    }

}
