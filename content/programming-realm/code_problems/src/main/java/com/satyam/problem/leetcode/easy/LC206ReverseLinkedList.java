package com.satyam.problem.leetcode.easy;

/**

 LC #206
 Reverse a singly linked list

 Submission Detail (Iterative)
    Link: https://leetcode.com/submissions/detail/286627664/
    Runtime: 0 ms
    Memory: 37 MB

 Submission Detail (Recursive)
     Link: https://leetcode.com/submissions/detail/286627664/
     Runtime: 0 ms
     Memory: 37.3 MB

 */

public class LC206ReverseLinkedList {

    /**
     * Recursive solution
     * @param head
     * @return
     */
    public ListNode reverseListRecursively(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode next = head.next;
        curr.next = null;
        if (next == null) {
            return curr;
        }

        ListNode reverse = reverseListRecursively(next);
        next.next = curr;
        return reverse;
    }

    /**
     * Iterative solution
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    // given by leetcode
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
