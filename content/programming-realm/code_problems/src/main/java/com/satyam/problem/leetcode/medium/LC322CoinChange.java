package com.satyam.problem.leetcode.medium;

import java.util.Arrays;

/**

 LC #322
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination
 of the coins, return -1.

 Example 1:
 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1

 Example 2:
 Input: coins = [2], amount = 3
 Output: -1

 Note:
 You may assume that you have an infinite number of each kind of coin.

 Idea:
 This is an extension of House Robber. There are two cases here
 1) 1st element is included and last is not included
 2) 1st is not included and last is included.

 Therefore, we can use the similar dynamic programming approach to scan the array twice and get the larger value.

 Submission Detail
     Link: https://leetcode.com/submissions/detail/312287531/
     Runtime: 0 ms
     Memory: 36.9 MB

 */

public class LC322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
