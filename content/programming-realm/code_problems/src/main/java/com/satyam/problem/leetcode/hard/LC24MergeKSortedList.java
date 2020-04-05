package com.satyam.problem.leetcode.hard;

/**

 LC #24
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:
 Input:
 [
     1->4->5,
     1->3->4,
     2->6
 ]
 Output: 1->1->2->3->4->4->5->6

 Idea: k = number of linked lists
    Solution 1: Use priority queue. Add all nodes in priority queue and then create LL by polling the queue. [NlogK]
    Solution 2: Merge lists one by one - O(kN)
    Solution 3: Merge with divide and conquer - O(N logk)

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291724581/
    Runtime: 2 ms
    Memory: 41.5 MB

 */

public class LC24MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int lastListIndex = lists.length - 1;
        while (lastListIndex != 0) {
            int low = 0, high = lastListIndex;
            while (low < high) {
                lists[low] = mergeTwoLists(lists[low], lists[high]);
                low++;
                high--;
                if (low >= high) {
                    lastListIndex = high;
                }
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        if (one != null) {
            curr.next = one;
        }

        if (two != null) {
            curr.next = two;
        }
        return dummy.next;
    }


    // GIVEN By leetcode
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
