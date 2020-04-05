package com.satyam.problem.leetcode.easy;

/**

 LC #121
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.

 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Not 7-1 = 6, as selling price needs to be larger than buying price.

 Idea:
 The points of interest are the peaks and valleys in the graph that can be plotted by the given numbers.
 We need to find the largest peak following the smallest valley.
 We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit
 (maximum difference between selling price and minprice) obtained so far respectively.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/276533945/
    Runtime: 0 ms
    Memory: 37.3 MB

 */

public class LC121BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
