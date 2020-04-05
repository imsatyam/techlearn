package com.satyam.problem.leetcode.medium;

import java.util.PriorityQueue;

/**

 LC #378
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 Idea:
    - Create min heap from first row elements
    - Do following k times
        - poll an element from heap
        - add new node in heap which is the next element in same column
    - return the last polled element

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291785634/
    Runtime: 17 ms
    Memory: 43.6 MB

 */

public class LC378KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        PriorityQueue<HeapNode> queue = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int c = 0; c < matrix[0].length; c++) {
            queue.offer(new HeapNode(matrix[0][c], 0, c));
        }

        int count = k;
        HeapNode minEle = null;
        while (count-- > 0) {
            minEle = queue.poll();

            int nextVal = minEle.r + 1 < matrix.length
                    ? matrix[minEle.r + 1] [minEle.c] : Integer.MAX_VALUE;

            queue.offer(new HeapNode(nextVal, minEle.r + 1, minEle.c));
        }
        return minEle.data;
    }

    static class HeapNode {
        int data, r, c;

        public HeapNode(int data, int r, int c) {
            this.data = data;
            this.r = r;
            this.c = c;
        }

        public HeapNode(HeapNode node) {
            this.data = node.data;
            this.r = node.r;
            this.c = node.c;
        }
    }

}
