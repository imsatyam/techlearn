package com.satyam.problem.leetcode.easy;

/**

 LC #83
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2

 Idea:
    use list traversal

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308175827/
    Runtime: 0 ms
    Memory: 41.3 MB

 */

public class LC83RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
