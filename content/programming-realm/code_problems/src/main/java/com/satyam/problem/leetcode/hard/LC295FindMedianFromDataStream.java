package com.satyam.problem.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**

 LC #295
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 For example,
 [2,3,4], the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.


 Example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2

 Idea:
     Use min and max heap

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291768849/
    Runtime: 76 ms
    Memory: 66.7 MB

 */

public class LC295FindMedianFromDataStream {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public LC295FindMedianFromDataStream() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        return left.size() > right.size()
                ? (double) left.peek()
                : (left.peek() + right.peek()) * 0.5;
    }

}
