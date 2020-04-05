package com.satyam.problem.leetcode.medium;

/**

 LC #238
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to
 the product of all the elements of nums except nums[i].

 Idea:
    Create product array -> capture multiplication left to right -> capture multiplication right to left

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286629358/
    Runtime: 1 ms
    Memory: 41.6 MB

 */

public class LC238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] products = new int[nums.length];
        products[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] = products[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return products;
    }

}
