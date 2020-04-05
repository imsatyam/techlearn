package com.satyam.problem.leetcode.medium;

/**

 LC #116
 You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

 struct Node {
 int val;
 Node *left;
 Node *right;
 Node *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Idea:
    - Because it is a perfect binary tree, all levels are full
    - traverse the tree
    - At each node connect the left and right child.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/278783440/
    Runtime: 0 ms
    Memory: 38 MB

 */

public class LC116NextRightPointerInPerfectBinaryTree {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        doConnect(root);
        return root;
    }

    private void doConnect(Node node) {
        Node left = node.left;
        Node right = node.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(node.left);
        connect(node.right);
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
