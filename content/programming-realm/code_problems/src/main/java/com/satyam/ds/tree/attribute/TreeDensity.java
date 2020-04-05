package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

/**
 * size / height
 */
public class TreeDensity {

    private static int getHeightAndSize(SimpleBinaryTreeNode node, TreeSize treeSize) {
        if (null == node) {
            return 0;
        }
        int leftHeight = getHeightAndSize(node.getLeft(), treeSize);
        int rightHeight = getHeightAndSize(node.getRight(), treeSize);
        treeSize.size++;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        TreeSize treeSize = new TreeSize();
        int height = getHeightAndSize(node, treeSize);
        double density = (double) treeSize.size / (double) height;
        System.out.println("Density: " + density);
    }

    static class TreeSize {
        private int size;
    }
}
