package com.satyam.problem.leetcode.medium;

/**

 LC #82
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Return the linked list sorted as well.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5

 Idea:
    use list traversal and add a dummy node

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308179343/
    Runtime: 0 ms
    Memory: 39.5 MB

 */

public class LC82RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while(p.next!=null && p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null && p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
        }
        return t.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
