package com.satyam.ds.tree.attribute;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

public class InorderPredecessor {

    private static SimpleBinaryTreeNode findInorderPredecessor(SimpleBinaryTreeNode root, SimpleBinaryTreeNode node) {
        if (root == null || node == null) {
            return null;
        }

        if (node.getLeft() != null) {
            return getLargestNodeInTree(node.getLeft());
        }

        SimpleBinaryTreeNode predecessor = null;
        while (root != null) {
            if (node.getValue() == root.getValue()) {
                break;
            } if (node.getValue() < root.getValue()) {
                root = root.getLeft();
            } else {
                predecessor = root;
                root = root.getRight();
            }
        }
        return predecessor;
    }

    private static SimpleBinaryTreeNode getLargestNodeInTree(SimpleBinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        SimpleBinaryTreeNode curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }
        return curr;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode root = TreeUtils.createSimpleBinarySearchTree();
        SimpleBinaryTreeNode node = root.getRight();
        SimpleBinaryTreeNode inorderPredecessor = findInorderPredecessor(root, node);
        if (inorderPredecessor == null) {
            System.out.println("Inorder predecessor of " + node.getValue() + " is not found!");
        } else {
            System.out.println("Inorder predecessor of " + node.getValue() + " is: " + inorderPredecessor.getValue());
        }
    }

}
