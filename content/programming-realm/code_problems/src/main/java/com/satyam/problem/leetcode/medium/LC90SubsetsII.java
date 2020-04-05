package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 LC #90
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 Idea:
    Similar to subsets 1 except duplicates.
    Sort the array to get rid of duplicates.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279488407/
    Runtime: 1 ms
    Memory: 37.8 MB

 */

public class LC90SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        Arrays.sort(nums);
        gatherSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void gatherSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            gatherSubsets(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

}
