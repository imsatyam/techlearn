package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class InorderSuccessor {

    private static SimpleBinaryTreeNode findInorderSuccessor(SimpleBinaryTreeNode root, SimpleBinaryTreeNode node) {
        if (root == null || node == null) {
            return null;
        }

        if (node.getRight() != null) {
            return getSmallestNodeInTree(node.getRight());
        }

        SimpleBinaryTreeNode successor = null;
        while (root != null) {
            if (node.getValue() == root.getValue()) {
                break;
            } if (node.getValue() < root.getValue()) {
                successor = root;
                root = root.getLeft();
            } else {
                root = root.getRight();
            }
        }
        return successor;
    }

    private static SimpleBinaryTreeNode getSmallestNodeInTree(SimpleBinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        SimpleBinaryTreeNode curr = root;
        while (curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        return curr;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode root = TreeUtils.createSimpleBinarySearchTree();
        SimpleBinaryTreeNode node = root.getLeft().getRight();
        SimpleBinaryTreeNode inorderSuccessor = findInorderSuccessor(root, node);
        if (inorderSuccessor == null) {
            System.out.println("Inorder successor of " + node.getValue() + " is not found!");
        } else {
            System.out.println("Inorder successor of " + node.getValue() + " is: " + inorderSuccessor.getValue());
        }
    }

}
