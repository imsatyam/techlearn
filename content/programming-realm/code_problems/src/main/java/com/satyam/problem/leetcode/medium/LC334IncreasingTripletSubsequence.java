package com.satyam.problem.leetcode.medium;

/**

 LC #334
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:
 Input: [1,2,3,4,5]
 Output: true

 Example 2:
 Input: [5,4,3,2,1]
 Output: false

 Idea:
 The idea of the problem is to check where there is a range from i to j, inclusive, so that its sum equals to k,
 nd the length of the range is the maximum.

 So we can naturally think of this question as a range summary problem, and we need to calculate
 the prefix sum of the array first. So the sum(i, j) = presum[j] - presum[i - 1] = k

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279269335/
    Runtime: 0 ms
    Memory: 38.3 MB

 */

public class LC334IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > min2) {
                return true;
            } else if (num < min1) {
                min1 = num;
            } else if (num > min1 && num < min2) {
                min2 = num;
            }
        }
        return false;
    }

}
