package com.satyam.ds.tree.miscellaneous;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;
import com.satyam.ds.tree.traversal.LevelOrderTraversal;

/**
    Convert a tree into its mirror tree
    Time complexity: O(N)
 */

public class MirrorTreeConvertor {

    public static SimpleBinaryTreeNode toMirrorTree(SimpleBinaryTreeNode node) {

        if (node == null) {
            return node;
        }

        SimpleBinaryTreeNode left = toMirrorTree(node.getLeft());
        SimpleBinaryTreeNode right = toMirrorTree(node.getRight());

        node.setLeft(right);
        node.setRight(left);

        return node;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        System.out.println("Given tree: ");
        LevelOrderTraversal.doLevelOrderTraversal(node);

        SimpleBinaryTreeNode mirror = toMirrorTree(node);
        System.out.println("Mirror tree: ");
        LevelOrderTraversal.doLevelOrderTraversal(mirror);
    }

}
