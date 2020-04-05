package com.satyam.ds.tree.common;

public class SimpleBinaryTreeNode {

    private int value;
    private SimpleBinaryTreeNode left;
    private SimpleBinaryTreeNode right;

    public SimpleBinaryTreeNode() {
    }

    public SimpleBinaryTreeNode(int value) {
        this.value = value;
    }

    public SimpleBinaryTreeNode(int value, SimpleBinaryTreeNode left, SimpleBinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SimpleBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(SimpleBinaryTreeNode left) {
        this.left = left;
    }

    public SimpleBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(SimpleBinaryTreeNode right) {
        this.right = right;
    }
}
