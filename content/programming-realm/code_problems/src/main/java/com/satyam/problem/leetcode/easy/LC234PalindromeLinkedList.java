package com.satyam.problem.leetcode.easy;

/**

 LC #234
 Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true

 Idea:
  - Find middle of linkedlist
  - reverse the second half
  - compare
  - combine the two halves again.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277232473/
    Runtime: 1 ms
    Memory: 44.7 MB

 */

public class LC234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = null, slow = head, fast = head, prevToSlow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevToSlow = slow;
            slow = slow.next;
        }

        if (fast != null) {
            mid = slow;
            slow = slow.next;
        }

        // first half ends at prevToSlow and second half starts at slow
        prevToSlow.next = null;

        // second half is reversed
        ListNode secondHalf = reverse(slow);
        boolean isPalindrome = compareList(head, secondHalf);
        secondHalf = reverse(secondHalf);

        if (mid != null) {
            prevToSlow.next = mid;
            mid.next = secondHalf;
        } else {
            prevToSlow.next = secondHalf;
        }

        return isPalindrome;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private boolean compareList(ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2;
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                return false;
            }
        }
        return (l1 == null && l2 == null);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
