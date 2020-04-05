package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class PostOrderTraversal {

    private static void doPostOrderTraversal(SimpleBinaryTreeNode node) {
        if (null == node) {
            return;
        }
        doPostOrderTraversal(node.getLeft());
        doPostOrderTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doPostOrderTraversal(node);
    }
}
