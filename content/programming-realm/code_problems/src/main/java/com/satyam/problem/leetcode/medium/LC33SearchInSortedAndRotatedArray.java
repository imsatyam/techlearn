package com.satyam.problem.leetcode.medium;

/**

 LC #33
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 Your algorithm's runtime complexity must be in the order of O(log n).

 Idea:
    Use binary search

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277297545/
    Runtime: 0 ms
    Memory: 38.2 MB

 */

public class LC33SearchInSortedAndRotatedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int mid = (end + start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] <= nums[mid]) {     // is left side sorted?
            if (target >= nums[start] && target <= nums[mid]) {
                return binarySearch(nums, start, mid - 1, target);
            }
            return binarySearch(nums, mid + 1, end, target);
        }

        if (target >= nums[mid] && target <= nums[end]) {
            return binarySearch(nums, mid + 1, end, target);
        }
        return binarySearch(nums, start, mid - 1, target);
    }

}
