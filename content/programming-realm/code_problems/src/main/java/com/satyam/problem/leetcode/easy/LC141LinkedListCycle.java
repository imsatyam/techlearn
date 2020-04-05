package com.satyam.problem.leetcode.easy;

/**

 LC #141
 Given a linked list, determine if it has a cycle in it.

 Idea:
    Floyd’s Cycle-Finding Algorithm

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277221258/
    Runtime: 0 ms
    Memory: 36.8 MB

 */

public class LC141LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    // Leetcode - given class
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
