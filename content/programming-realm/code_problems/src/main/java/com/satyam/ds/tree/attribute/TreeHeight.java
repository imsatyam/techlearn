package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class TreeHeight {

    public static int getHeight(SimpleBinaryTreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        int height = getHeight(node);
        System.out.println("Height: " + height);
    }

}
