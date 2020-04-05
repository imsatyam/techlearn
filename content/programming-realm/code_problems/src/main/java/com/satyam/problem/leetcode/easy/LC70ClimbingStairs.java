package com.satyam.problem.leetcode.easy;

/**

 LC #70
 You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.

 Idea:

    Brute Force:
        We take all possible step combinations i.e. 1 and 2, at every step.
        At every step we are calling the function climbStairsclimbStairs for step 11 and 22, and return the sum of
        returned values of both functions.

        climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)

        Time complexity: O(2^n)
        Space Complexity: n

    Dynamic Programming
        dp[i] = dp[i - 1] + dp[i -2];
        Time complexity: O(n)
        Space Complexity: O(n)

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286660311/
    Runtime: 0 ms
    Memory: 33 MB

 */

public class    LC70ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        // DP array to hold possibilities for each value of n
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }

        return dp[n];
    }

}
