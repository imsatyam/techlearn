package com.satyam.problem.leetcode.medium;

/**

 LC #98
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:
  - The left subtree of a node contains only nodes with keys less than the node's key.
  - The right subtree of a node contains only nodes with keys greater than the node's key.
  - Both the left and right subtrees must also be binary search trees.

 Idea:
    Traverse by passing the minimum and the maximum value possible at any node.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279496503/
    Runtime: 0 ms
    Memory: 39.4 MB

 */

public class LC98ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        boolean isValid = false;
        if(root.val < max && root.val > min) {
            isValid = true;
        }

        return isValid && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    // GIVEN class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
