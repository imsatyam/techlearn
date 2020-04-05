package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalUsingQueue {

    public static List<List<Integer>> doLevelOrderTraversal(SimpleBinaryTreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        if (root == null) {
            return levelOrderList;
        }

        Queue<SimpleBinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            levelOrderList.add(levelNodes);
            while (levelWidth-- > 0) {
                SimpleBinaryTreeNode node = queue.poll();
                levelNodes.add(node.getValue());
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }

        return levelOrderList;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        List<List<Integer>> lists = doLevelOrderTraversal(node);
        for (List<Integer> level : lists) {
            System.out.println(level);
        }
    }
}
