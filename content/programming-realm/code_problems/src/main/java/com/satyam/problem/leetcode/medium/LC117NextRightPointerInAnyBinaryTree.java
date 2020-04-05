package com.satyam.problem.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**

 LC #117
 Given a binary tree, Populate each next pointer to point to its next right node. If there is no next right node,
 the next pointer should be set to NULL.
 Initially, all next pointers are set to NULL.

 Idea:
    - Use level order traversal with a pointer to previous node.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279504991/
    Runtime: 1 ms
    Memory: 54.3 MB

 */

public class LC117NextRightPointerInAnyBinaryTree {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (i == size - 1) {
                    cur.next = null;
                }
                if (i > 0) {
                    prev.next = cur;
                }
                prev = cur;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

    // GIVEN class
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
