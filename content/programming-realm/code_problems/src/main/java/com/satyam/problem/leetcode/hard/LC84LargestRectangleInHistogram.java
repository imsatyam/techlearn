package com.satyam.problem.leetcode.hard;

import java.util.Stack;

/**

 LC #84
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.

 Input: [2,1,5,6,2,3]
 Output: 10

 Idea:
    - Use stack to store index
    - if stack is empty or height[i] >= height[top]
        - push index to stack
    - Otherwise, calculate area
         if (stack.isEmpty()) {
            area = heights[top] * i;
         } else {
            area = heights[top] * (i - stack.peek() - 1);
         }


 Submission Detail
    Link: https://leetcode.com/submissions/detail/279483143/
    Runtime: 13 ms
    Memory: 40.9 MB

 */

public class LC84LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int maxArea = 0;

        while ( i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                maxArea = Math.max(maxArea, getArea(heights, stack, i));
            }
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, getArea(heights, stack, i));
        }

        return maxArea;
    }

    private int getArea(int[] heights, Stack<Integer> stack, int i) {
        int top = stack.pop();
        int area = 0;
        if (stack.isEmpty()) {
            area = heights[top] * i;
        } else {
            area = heights[top] * (i - stack.peek() - 1);
        }
        return area;
    }
}
