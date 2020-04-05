package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class TreeDiameter {

    public static int getDiameter(SimpleBinaryTreeNode node) {
        if (null == node) {
            return 0;
        }

        int leftHeight = TreeHeight.getHeight(node.getLeft());
        int rightHeight = TreeHeight.getHeight(node.getRight());
        int leftDiameter = getDiameter(node.getLeft());
        int rightDiameter = getDiameter(node.getRight());
        return Math.max( (1 + leftHeight + rightHeight), Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        int diameter = getDiameter(node);
        System.out.println("Diameter: " + diameter);
    }
}
