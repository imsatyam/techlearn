package com.satyam.problem.leetcode.medium;

/**

 LC #8
 Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
 possible, and interprets them as a numerical value.
 The string can contain additional characters after those that form the integral number, which are ignored and have no
 effect on the behavior of this function.

 Idea:
    Handle negatives and overflows explicitly.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277290227/
    Runtime: 2 ms
    Memory: 39.5 MB

 */

public class LC8StringToInteger {

    public int myAtoi(String str) {

        if (str == null || str.trim().equals("")) {
            return 0;
        }

        str = str.trim();


        boolean isNegative = false;
        char sign = str.charAt(0);
        if (sign == '-' || sign == '+') {
            str = str.substring(1);
            if(sign == '-') {
                isNegative = true;
            }
        }

        long value = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                value = (value * 10) + (c - '0');
                if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        if (value == 0) {
            return 0;
        }

        value = isNegative ? value * -1 : value;
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)value;
    }

}
