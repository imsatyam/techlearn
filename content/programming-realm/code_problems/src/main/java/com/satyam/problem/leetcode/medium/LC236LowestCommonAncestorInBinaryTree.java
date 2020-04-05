package com.satyam.problem.leetcode.medium;

/**

 LC #236
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree

 Idea:
    Recursion

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286628383/
    Runtime: 5 ms
    Memory: 35.3 MB

 */

public class LC236LowestCommonAncestorInBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;

    }



    // Given by leetcode
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
