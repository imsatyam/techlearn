package com.satyam.problem.leetcode.medium;

import java.util.PriorityQueue;

/**

 LC #215
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 not the kth distinct element

 Idea:
    Use min heap of size k.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277533328/
    Runtime: 5 ms
    Memory: 37.8 MB

 */

public class LC215KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

}
