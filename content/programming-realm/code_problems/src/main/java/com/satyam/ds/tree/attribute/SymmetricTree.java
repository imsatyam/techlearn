package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class SymmetricTree {

    private static boolean isSymmetric(SimpleBinaryTreeNode node1, SimpleBinaryTreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        }

        if (null == node1 || null == node2) {
            return false;
        }

        if (null != node1 && null != node2 && node1.getValue() == node2.getValue()) {
            return isSymmetric(node1.getLeft(), node2.getRight()) && isSymmetric(node1.getRight(), node2.getLeft());
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        boolean isSymmetric = isSymmetric(node, node);
        System.out.println("Symmetric: " + isSymmetric);
    }

}
