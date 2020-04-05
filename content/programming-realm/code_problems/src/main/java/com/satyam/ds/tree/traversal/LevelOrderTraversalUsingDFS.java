package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalUsingDFS {

    public static List<List<Integer>> doLevelOrderTraversal(SimpleBinaryTreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }

        dfs(root, 0, levelOrderList);
        return levelOrderList;
    }

    private static void dfs(SimpleBinaryTreeNode root, int level, List<List<Integer>> levelOrderList) {
        if (root == null) {
            return;
        }

        if (levelOrderList.size() <= level) {
            levelOrderList.add(new ArrayList<>());
        }

        levelOrderList.get(level).add(root.getValue());
        dfs(root.getLeft(), level + 1, levelOrderList);
        dfs(root.getRight(), level + 1, levelOrderList);
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        List<List<Integer>> lists = doLevelOrderTraversal(node);
        for (List<Integer> level : lists) {
            System.out.println(level);
        }
    }
}
