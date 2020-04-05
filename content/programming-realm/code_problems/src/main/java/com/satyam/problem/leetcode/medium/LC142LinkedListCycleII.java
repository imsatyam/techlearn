package com.satyam.problem.leetcode.medium;

/**

 LC #142
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 To represent a cycle in the given linked list, we use an integer pos which represents the position
 (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 Note: Do not modify the linked list.

 Idea:
 Use Floyd cycle detection algorithm

 Submission Detail
 Link: https://leetcode.com/submissions/detail/308173471/
 Runtime: 0 ms
 Memory: 41.1 MB

 */
public class LC142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode runner = head;
        ListNode walker = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                break;
            }
        }

        if (walker == runner) {
            walker = head;
            while (walker != runner) {
                walker = walker.next;
                runner = runner.next;
            }
            return walker;
        }
        return null;
    }

    // Leetcode - given class
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
