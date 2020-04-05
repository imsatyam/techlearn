package com.satyam.ds.tree.common;

public class TreeUtils {

    public static SimpleBinaryTreeNode createSimpleBinaryTree() {
        SimpleBinaryTreeNode node1 = new SimpleBinaryTreeNode(5);
        SimpleBinaryTreeNode node2 = new SimpleBinaryTreeNode(7);
        SimpleBinaryTreeNode node3 = new SimpleBinaryTreeNode(2);
        SimpleBinaryTreeNode node4 = new SimpleBinaryTreeNode(1);
        SimpleBinaryTreeNode node5 = new SimpleBinaryTreeNode(3);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setRight(node5);
        return node1;
    }

    public static SimpleBinaryTreeNode createSimpleBinarySearchTree() {
        SimpleBinaryTreeNode node1 = new SimpleBinaryTreeNode(20);
        SimpleBinaryTreeNode node2 = new SimpleBinaryTreeNode(8);
        SimpleBinaryTreeNode node3 = new SimpleBinaryTreeNode(22);
        SimpleBinaryTreeNode node4 = new SimpleBinaryTreeNode(4);
        SimpleBinaryTreeNode node5 = new SimpleBinaryTreeNode(12);
        SimpleBinaryTreeNode node6 = new SimpleBinaryTreeNode(10);
        SimpleBinaryTreeNode node7 = new SimpleBinaryTreeNode(14);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node6);
        node5.setRight(node7);
        return node1;
    }

}
