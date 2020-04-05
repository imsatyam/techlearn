package com.satyam.problem.leetcode.easy;

/**

 LC #21
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 the nodes of the first two lists.

 Idea:
    Iterate and merge

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286625398/
    Runtime: 0 ms
    Memory: 39.6 MB

 */

public class LC21Merge2SortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return dummy.next;
    }


    // Leetcode - given class
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
