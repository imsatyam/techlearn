package com.satyam.problem.leetcode.hard;

/**

 LC #164
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Example 1:
 Input: [3,6,9,1]
 Output: 3
 Explanation: The sorted form of the array is [1,3,6,9], either
 (3,6) or (6,9) has the maximum difference 3.

 Example 2:
 Input: [10]
 Output: 0
 Explanation: The array contains less than 2 elements, therefore return 0.
 Note:

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 Try to solve it in linear time/space.

 Idea:
     Use pigeonhole principle

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286859785/
    Runtime: 3 ms
    Memory: 36.8 MB

 */

public class LC164MaximumGap {

    public int maximumGap(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketSize = Math.max(1, ((max - min) / (nums.length - 1)));
        int bucketCount = 1 + (max - min) / bucketSize;

        Bucket[] buckets = new Bucket[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new Bucket(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int bucketIndex = (num - min) / bucketSize;
            buckets[bucketIndex].isUsed = true;
            buckets[bucketIndex].minVal = Math.min(num, buckets[bucketIndex].minVal);
            buckets[bucketIndex].maxVal = Math.max(num, buckets[bucketIndex].maxVal);
        }

        int prevBucketMax = min;
        int maxGap = 0;
        for (int index = 0; index < buckets.length; index++) {
            Bucket b = buckets[index];
            if (!b.isUsed) {
                continue;
            } else {
                maxGap = Math.max(maxGap, b.minVal - prevBucketMax);
                prevBucketMax = b.maxVal;
            }
        }
        return maxGap;
    }

    static class Bucket {
        boolean isUsed = false;
        int minVal;
        int maxVal;

        public Bucket(int minVal, int maxVal) {
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }

}
