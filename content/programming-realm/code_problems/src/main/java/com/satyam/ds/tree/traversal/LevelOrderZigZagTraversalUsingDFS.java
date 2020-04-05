package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderZigZagTraversalUsingDFS {

    public static List<List<Integer>> doLevelOrderTraversal(SimpleBinaryTreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }

        dfs(root, 0, levelOrderList, true);
        return levelOrderList;
    }

    private static void dfs(SimpleBinaryTreeNode root, int level, List<List<Integer>> levelOrderList, boolean isLeftToRight) {
        if (root == null) {
            return;
        }

        if (levelOrderList.size() <= level) {
            levelOrderList.add(new LinkedList<>());
        }

        LinkedList<Integer> list = (LinkedList<Integer>)levelOrderList.get(level);
        if (isLeftToRight) {
            list.add(root.getValue());
        } else {
            list.addFirst(root.getValue());
        }

        dfs(root.getLeft(), level + 1, levelOrderList, !isLeftToRight);
        dfs(root.getRight(), level + 1, levelOrderList, !isLeftToRight);
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        List<List<Integer>> lists = doLevelOrderTraversal(node);
        for (List<Integer> level : lists) {
            System.out.println(level);
        }
    }
}
