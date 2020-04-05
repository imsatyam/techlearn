package com.satyam.problem.leetcode.easy;

/**

 LC #35
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2

 Idea:
    Use binary search

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308674084/
    Runtime: 1 ms
    Memory: 39.8 MB

 */

public class LC35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + ( r - l) / 2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

}
