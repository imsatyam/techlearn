package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**

 LC #102
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 Idea:
    Use DFS

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277532781/
    Runtime: 0 ms
    Memory: 36.1 MB

 */

public class LC102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }

        dfs(root, 0, levelOrderList);
        return levelOrderList;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> levelOrderList) {
        if (root == null) {
            return;
        }

        if (levelOrderList.size() <= level) {
            levelOrderList.add(new ArrayList<>());
        }

        levelOrderList.get(level).add(root.val);
        dfs(root.left, level + 1, levelOrderList);
        dfs(root.right, level + 1, levelOrderList);
    }



    // Leetcode given
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
