package com.satyam.problem.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**

 LC #105
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7

 Idea:
    Use DFS

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308645973/
    Runtime: 1 ms
    Memory: 41.3 MB

 */

public class LC105BinaryTreeFromInorderAndPreorder {

    private static int pIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }

        pIndex = 0;
        return buildTree(preorder, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(
            int[] preorder, Map<Integer, Integer> map, int start, int end) {

        if (start > end || pIndex >= preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pIndex]);
        pIndex++;

        if (start == end) {
            return node;
        }

        int rootIndex = map.get(node.val);
        node.left = buildTree(preorder, map, start, rootIndex-1);
        node.right = buildTree(preorder, map, rootIndex+1, end);

        return node;
    }

    // Leetcode given
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
