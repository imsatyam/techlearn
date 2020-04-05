package com.satyam.problem.leetcode.easy;

/**

 LC #235
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 Idea:
    Recursion

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291441197/
    Runtime: 4 ms
    Memory: 39.2 MB

 */

public class LC235LowestCommonAncestorInBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    // Given by leetcode
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
