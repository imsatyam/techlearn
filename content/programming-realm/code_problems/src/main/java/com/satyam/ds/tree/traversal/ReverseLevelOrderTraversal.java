package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.attribute.TreeHeight;
import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class ReverseLevelOrderTraversal {

    private static void doLevelOrderTraversal(SimpleBinaryTreeNode node) {
        if (null == node) {
            return;
        }

        int height = TreeHeight.getHeight(node);
        for(int level = height; level >= 1; level--) {
            printGivenLevel(node, level);
        }
    }

    private static void printGivenLevel(SimpleBinaryTreeNode node, int level) {
        if (null == node) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getValue() + " ");
        } else if (level > 1) {
            printGivenLevel(node.getLeft(), level -1);
            printGivenLevel(node.getRight(), level -1);
        }
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doLevelOrderTraversal(node);
    }
}
