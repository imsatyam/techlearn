package com.satyam.problem.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**

 LC #257
 Given a binary tree, return all root-to-leaf paths.
 Output: ["1->2->5", "1->3"]

 Idea:
    Traversal

 Submission Detail
    Link: https://leetcode.com/submissions/detail/287161256/
    Runtime: 1 ms
    Memory: 36.5 MB

 */

public class LC257BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        traverseBinaryTreePaths(root, result, builder);
        return result;
    }

    private void traverseBinaryTreePaths(TreeNode root, List<String> result, StringBuilder builder) {
        if (root == null) {
            return;
        }

        builder.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(builder.toString());
            return;
        }

        int currLen = builder.length();
        if (root.left != null) {
            builder.append("->");
            traverseBinaryTreePaths(root.left, result, builder);
            builder.delete(currLen, builder.length());
        }

        if (root.right != null) {
            builder.append("->");
            traverseBinaryTreePaths(root.right, result, builder);
            builder.delete(currLen, builder.length());
        }
    }

    // Leetcode given
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
