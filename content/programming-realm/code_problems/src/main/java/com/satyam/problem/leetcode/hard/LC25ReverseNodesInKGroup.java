package com.satyam.problem.leetcode.hard;

/**

 LC #25
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list.
 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Note:
  - Only constant extra memory is allowed.
  - You may not alter the values in the list's nodes, only nodes itself may be changed.

 Idea:
    Use linked list reverse. Keep track of current length and k

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291730085/
    Runtime: 0 ms
    Memory: 38.5 MB

 */

public class LC25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        return reverse(head, k, size);

    }

    private ListNode reverse(ListNode head, int k, int currSize) {

        if (currSize < k) {
            return head;
        }

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverse(next, k, currSize - k);
        }

        return prev;
    }


    // GIVEN By leetcode
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
