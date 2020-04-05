package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class InOrderTraversal {

    private static void doInOrderTraversal(SimpleBinaryTreeNode node) {
        if (null == node) {
            return;
        }
        doInOrderTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        doInOrderTraversal(node.getRight());
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doInOrderTraversal(node);
    }
}
