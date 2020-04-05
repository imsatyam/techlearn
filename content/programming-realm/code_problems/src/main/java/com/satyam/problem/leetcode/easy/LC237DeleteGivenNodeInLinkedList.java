package com.satyam.problem.leetcode.easy;

/**

 LC #237
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Idea:
    Here we do not have previous to node so that we can link it with curr.next.
    Therefore, the approach would be to replace value of current node with value of next node and then delete the next
    node by linking current node to next.next.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286628747/
    Runtime: 0 ms
    Memory: 36.4 MB

 */

public class LC237DeleteGivenNodeInLinkedList {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Leetcode - given class
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
