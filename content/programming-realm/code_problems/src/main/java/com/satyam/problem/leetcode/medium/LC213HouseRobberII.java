package com.satyam.problem.leetcode.medium;

/**

 LC #213
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent
 houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 money you can rob tonight without alerting the police.

 Example 1:
 Input: [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 because they are adjacent houses.

 Example 2:
 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.

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

public class LC213HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int rob(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        int sumTillPrevHouse = 0;
        int sumTillSecPrevHouse = 0;

        for (int index = start; index <= end; index++) {
            int curr = Math.max(sumTillPrevHouse, sumTillSecPrevHouse + nums[index]);
            sumTillSecPrevHouse = sumTillPrevHouse;
            sumTillPrevHouse = curr;
        }

        return sumTillPrevHouse;
    }
}
