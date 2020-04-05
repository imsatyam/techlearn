package com.satyam.problem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**

 LC #217
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.

 Idea:
    Use hashset

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277071872/
    Runtime: 9 ms
    Memory: 43.7 MB

 */

public class LC217ArrayContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 1) {
            return false;
        }

        Set<Integer> elements = new HashSet<>();
        for (int n : nums) {
            if (elements.contains(n)) {
                return true;
            }
            elements.add(n);
        }
        return false;
    }
}
