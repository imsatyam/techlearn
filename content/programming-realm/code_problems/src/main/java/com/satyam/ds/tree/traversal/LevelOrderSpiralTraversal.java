package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.attribute.TreeHeight;
import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class LevelOrderSpiralTraversal {

    private static void doLevelOrderTraversal(SimpleBinaryTreeNode node) {
        if (null == node) {
            return;
        }

        int height = TreeHeight.getHeight(node);
        boolean flip = false;
        for(int level = 1; level <= height; level++) {
            printGivenLevel(node, level, flip);
            flip = !flip;
        }
    }

    private static void printGivenLevel(SimpleBinaryTreeNode node, int level, boolean flip) {
        if (null == node) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getValue() + " ");
        } else if (level > 1) {

            if (!flip) {
                printGivenLevel(node.getLeft(), level -1, flip);
                printGivenLevel(node.getRight(), level -1, flip);
            } else {
                printGivenLevel(node.getRight(), level -1, flip);
                printGivenLevel(node.getLeft(), level -1, flip);
            }
        }
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doLevelOrderTraversal(node);
    }
}
