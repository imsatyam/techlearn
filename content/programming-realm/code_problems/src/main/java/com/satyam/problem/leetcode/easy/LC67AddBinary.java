package com.satyam.problem.leetcode.easy;

/**

 LC #67
 Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"

 Idea:
    Binary arithmetic

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279472771/
    Runtime: 1 ms
    Memory: 36.3 MB

 */

public class LC67AddBinary {

    public String addBinary(String a, String b) {
        if ((a == null && b == null) || (a.length() == 0 && b.length() == 0)) {
            return "";
        }

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum = sum + (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                sum = sum + (b.charAt(j--) - '0');
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

}
