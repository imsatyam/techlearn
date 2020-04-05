package com.satyam.problem.leetcode.medium;

/**

 LC #2
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 Idea:
    use list traversal and handle carry

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308183590/
    Runtime: 2 ms
    Memory: 40.9 MB

 */

public class LC2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode sumList = new ListNode(-1);

        ListNode first = l1;
        ListNode second = l2;
        ListNode curr = sumList;
        int carry = 0;

        while (first != null || second != null) {
            int x = 0;
            int y = 0;

            if (first != null) {
                x = first.val;
                first = first.next;
            }
            if (second != null) {
                y = second.val;
                second = second.next;
            }

            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return sumList.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
