package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class PreOrderTraversal {

    private static void doPreOrderTraversal(SimpleBinaryTreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.getValue() + " ");
        doPreOrderTraversal(node.getLeft());
        doPreOrderTraversal(node.getRight());
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doPreOrderTraversal(node);
    }
}
