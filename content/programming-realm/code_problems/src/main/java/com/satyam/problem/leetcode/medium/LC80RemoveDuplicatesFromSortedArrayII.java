package com.satyam.problem.leetcode.medium;

/**

 LC #80
 Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:
 Given nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 It doesn't matter what you leave beyond the returned length.

 Idea:
    Similar to remove duplicates except that here we need to keep track of count as well.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279478733/
    Runtime: 1 ms
    Memory: 37.1 MB

 */

public class LC80RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                count++;
                if (count < 2) {
                    i++;
                    nums[i] = nums[j];
                }
            } else {
                count = 0;
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

}
