package com.satyam.problem.leetcode.medium;

/**

 LC #50
 Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25

 Idea:
    - x^n = (x * x)^ n/2
    - Also, handle negative exponents and overflow

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279212045/
    Runtime: 1 ms
    Memory: 33.9 MB

 */

public class LC50NthPowerOfX {

    public double myPow(double x, int n) {
        boolean negativeExponent = n < 0;
        if (negativeExponent) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / calculatePow(x, - (n + 1)) / x;
            }
            return 1.0 / calculatePow(x, -n);
        }
        return calculatePow(x, n);
    }

    private double calculatePow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n % 2 == 1) {
            return x * calculatePow(x, n - 1);
        }

        return calculatePow(x * x, n / 2);
    }

}
