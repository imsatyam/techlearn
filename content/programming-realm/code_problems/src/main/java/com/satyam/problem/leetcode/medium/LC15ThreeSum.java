package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 LC #15
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets
 in the array which gives the sum of zero.

 The solution set must not contain duplicate triplets.

 Idea:
    Sort the array and then
    Convert the problem into a two sum problem by converting a + b + c = 0 into a + b = -c
    Take care of duplicates

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279194442/
    Runtime: 29 ms
    Memory: 47.9 MB

 */

public class LC15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return solutions;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            solveTwoSum(nums, i + 1, nums.length - 1, target, solutions);
        }
        return solutions;
    }

    private void solveTwoSum(int[] nums, int left, int right, int target, List<List<Integer>> solutions) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                solutions.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;

                // remove duplicates
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum > target) {
                right--;
            } else {
                left ++;
            }
        }
    }

}
