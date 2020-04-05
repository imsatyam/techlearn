package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeWidth {

    private static int getWidth(SimpleBinaryTreeNode node) {

        if (node == null) {
            return 0;
        }

        int maxWidth = 0;

        Queue<SimpleBinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int levelWidth = queue.size();
            maxWidth = Math.max(maxWidth, levelWidth);
            while (levelWidth-- > 0) {
                SimpleBinaryTreeNode nd = queue.poll();
                if (nd.getLeft() != null) {
                    queue.offer(nd.getLeft());
                }
                if (nd.getRight() != null) {
                    queue.offer(nd.getRight());
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        int height = getWidth(node);
        System.out.println("Width: " + height);
    }

}
