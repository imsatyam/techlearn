package com.satyam.problem.leetcode.medium;

/**

 LC #153
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:
 Input: [3,4,5,1,2]
 Output: 1

 Idea:
    Use binary search

 Submission Detail
    Link: https://leetcode.com/submissions/detail/310380586/
    Runtime: 1 ms
    Memory: 39.8 MB

 */

public class LC153MinimumElementInSortedRotatedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0, high = nums.length - 1;
        if (nums[high] > nums[low]) {
            return nums[0];
        }

        while(low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
