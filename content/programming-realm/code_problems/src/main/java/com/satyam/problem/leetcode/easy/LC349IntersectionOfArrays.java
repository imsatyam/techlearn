package com.satyam.problem.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**

 LC #349
 Given two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]

 Idea:
    Use set and its retainAll

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308210049/
    Runtime: 5 ms
    Memory: 40 MB

 */

public class LC349IntersectionOfArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int n : nums1) {
            set1.add(n);
        }
        for(int n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

}
