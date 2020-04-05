package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**

 LC #39
 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]

 Idea:
    Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291777228/
    Runtime: 2 ms
    Memory: 37.4 MB

 */

public class LC39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        doBacktracking(results, new ArrayList<>(), target, candidates, 0);
        return results;
    }

    private void doBacktracking(List<List<Integer>> results, List<Integer> currentList,
                                int sum, int[] candidates, int startIndex) {

        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }

        int i = startIndex;
        while ( i < candidates.length && sum - candidates[i] >= 0) {
            currentList.add(candidates[i]);
            doBacktracking(results, currentList, sum - candidates[i], candidates, i);
            currentList.remove(currentList.size() - 1);
            i++;
        }
    }

}
