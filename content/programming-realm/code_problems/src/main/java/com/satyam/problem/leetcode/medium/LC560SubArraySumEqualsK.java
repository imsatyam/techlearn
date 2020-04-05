package com.satyam.problem.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**

 LC #560
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 Idea:
    Use hash map

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308256748/
    Runtime: 12 ms
    Memory: 42.7 MB

 */

public class LC560SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumFrequencyMap = new HashMap<>();
        int count = 0, sum = 0;

        sumFrequencyMap.put(0, 1);

        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            if (sumFrequencyMap.containsKey(sum - k)) {
                count += sumFrequencyMap.get(sum - k);
            }
            sumFrequencyMap.put(sum, sumFrequencyMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
