package com.satyam.problem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**

 LC #1
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Idea:
    Use hashmap to store number and index.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286647354/
    Runtime: 2 ms
    Memory: 37.3 MB

 */

public class LC1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];
            if (numIndexMap.containsKey(diff)) {
                return new int[]{numIndexMap.get(diff), index};
            }
            numIndexMap.put(nums[index], index);
        }
        return new int[]{};
    }

}
