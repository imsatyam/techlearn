package com.satyam.problem.leetcode.hard;

/**

 LC #42
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.

 Idea:
    Since water trapped at any element = min( max_left, max_right) – arr[i] we will calculate water trapped on smaller
    element out of A[lo] and A[hi] first and move the pointers till lo doesn’t cross hi.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286626461/
    Runtime: 1 ms
    Memory: 36.1 MB

 */

public class LC42TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int low = 0, high = height.length - 1, leftMax = 0, rightMax = 0, waterUnits = 0;

        while (low < high) {
            if (height[low] < height[high]) {
                if (height[low] > leftMax) {
                    leftMax = height[low];
                } else {
                    waterUnits += leftMax - height[low];
                }
                low++;
            } else {
                if (height[high] > rightMax) {
                    rightMax = height[high];
                } else {
                    waterUnits += rightMax - height[high];
                }
                high--;
            }
        }
        return waterUnits;
    }

}
