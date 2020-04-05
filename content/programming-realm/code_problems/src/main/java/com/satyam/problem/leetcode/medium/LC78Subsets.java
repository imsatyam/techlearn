package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**

 LC #78
 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 Idea:
    Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279475544/
    Runtime: 0 ms
    Memory: 37.4 MB

 */

public class LC78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return subsets;
        }

        gatherSublists(nums, 0, new ArrayList<>(), subsets);
        return subsets;

    }

    private void gatherSublists(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            gatherSublists(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

}
