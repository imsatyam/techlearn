package com.satyam.problem.leetcode.medium;

/**

 LC #43
 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 - The length of both num1 and num2 is < 110.
 - Both num1 and num2 contain only digits 0-9.
 - Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 - You must not use any built-in BigInteger library or convert the inputs to integer directly.

 Idea:
    Use multiplication logic from school

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291379707/
    Runtime: 3 ms
    Memory: 36.6 MB

 */

public class LC43MultiplyStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 == 0 || len2 == 0) {
            return "";
        }

        int[] result = new int[len1 + len2];
        int in1 = 0;
        int in2 = 0;
        int i = 0, j = 0;;

        for (i = len1 - 1; i >= 0; i--) {

            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            in2 = 0;

            for (j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[in1 + in2] + carry;
                carry = sum / 10;
                result[in1 + in2] = sum % 10;
                in2++;
            }

            if (carry > 0) {
                result[in1 + in2] += carry;
            }
            in1++;
        }

        i = len1 + len2 - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }

        if (i == -1) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        while(i >= 0) {
            builder.append(result[i]);
            i--;
        }
        return builder.toString();
    }

}
