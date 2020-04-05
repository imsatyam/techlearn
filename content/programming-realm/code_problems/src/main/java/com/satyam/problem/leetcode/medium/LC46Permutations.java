package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 LC #46
 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 Idea:
    Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308670335/
    Runtime: 2 ms
    Memory: 47.3 MB

 */

public class LC46Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, List<Integer> currList, List<List<Integer>> result) {
        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int num : nums) {
            if (currList.contains(num)) {
                continue;
            }
            currList.add(num);
            permute(nums, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
