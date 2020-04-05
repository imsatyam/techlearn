package com.satyam.problem.leetcode.easy;


/**

 LC #104
 Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Idea:
    depth of a root = 1 + max (leftDepth, rightDepth)

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286626857/
    Runtime: 0 ms
    Memory: 38.5 MB

 */

public class LC104BinaryTreeDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);

    }

    // Leetcode given
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
