package com.satyam.ds.tree.miscellaneous;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;

import java.util.Objects;

/**

 Check if binary tree is a sum tree.

 Sum tree means, value(root) = sum(values of left subtree) + sum(values of right subtree)

 Idea:
 1. if leaf node => value = leaf node value
 2. if not a leaf node => value = 2 * value of node [assuming that it is a sum tree]

 */

public class SumTree {

    private static boolean isSumTree(SimpleBinaryTreeNode node) {
        if (Objects.isNull(node) || isLeaf(node)) {
            return true;
        }

        int leftSum = 0;
        int rightSum = 0;

        if (isSumTree(node.getLeft()) && isSumTree(node.getRight())) {
            if (node.getLeft() == null) {
                leftSum = 0;
            } else if(isLeaf(node.getLeft())) {
                leftSum = node.getLeft().getValue();
            } else {
                leftSum = 2 * node.getLeft().getValue();
            }

            if (node.getRight() == null) {
                rightSum = 0;
            } else if(isLeaf(node.getRight())) {
                rightSum = node.getRight().getValue();
            } else {
                rightSum = 2 * node.getRight().getValue();
            }

            if(leftSum + rightSum == node.getValue()){          // check left + right == val
                return true;
            }
        }

        return false;
    }

    private static boolean isLeaf(SimpleBinaryTreeNode node) {
        return node != null && node.getLeft() == null && node.getRight() == null;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode root = new SimpleBinaryTreeNode(26);
        root.setLeft(new SimpleBinaryTreeNode(10));
        root.setRight(new SimpleBinaryTreeNode(3));
        root.getLeft().setLeft(new SimpleBinaryTreeNode(4));
        root.getLeft().setRight(new SimpleBinaryTreeNode(6));
        root.getRight().setRight(new SimpleBinaryTreeNode(3));

        if (isSumTree(root)) {
            System.out.println("It is a sum tree!");
        } else {
            System.out.println("It is not a sum tree!");
        }

    }

}
