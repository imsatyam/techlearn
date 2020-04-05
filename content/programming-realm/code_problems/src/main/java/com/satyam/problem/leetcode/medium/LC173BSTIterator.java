package com.satyam.problem.leetcode.medium;

import java.util.Stack;

/**

 LC #173
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 Calling next() will return the next smallest number in the BST.

 Idea:
    - Pre-process left subtree to get the next smallest element.
    - in case that node has a right child add it later.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291425715/
    Runtime: 16 ms
    Memory: 49.9 MB

 */

public class LC173BSTIterator {

    private Stack<TreeNode> stack;

    public LC173BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.addLeftChildrenToStack(root);
    }

    private void addLeftChildrenToStack(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextSmaller = this.stack.pop();
        if (nextSmaller.right != null) {
            addLeftChildrenToStack(nextSmaller.right);
        }
        return nextSmaller.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // GIVEN class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
