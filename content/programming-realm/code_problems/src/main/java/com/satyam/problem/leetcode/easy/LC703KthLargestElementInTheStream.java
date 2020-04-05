package com.satyam.problem.leetcode.easy;

import java.util.PriorityQueue;

/**

 LC #703
 Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 not the kth distinct element.

 Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial
 elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

 Example:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5

 Idea:
    Use priority queue.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308189090/
    Runtime: 12 ms
    Memory: 44.5 MB

 */

public class LC703KthLargestElementInTheStream {

    private final int k;
    private final PriorityQueue<Integer> pq;

    public LC703KthLargestElementInTheStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        this.pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
