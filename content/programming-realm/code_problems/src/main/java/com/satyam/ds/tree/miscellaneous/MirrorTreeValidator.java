package com.satyam.ds.tree.miscellaneous;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;
import com.satyam.ds.tree.traversal.LevelOrderTraversal;

/**
    Check if the given trees are mirror image of each other
    Time complexity: O(N)
 */

public class MirrorTreeValidator {

    private static boolean isMirrorTree(SimpleBinaryTreeNode node1, SimpleBinaryTreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1 != null && node2 != null && node1.getValue() == node2.getValue()) {
            return isMirrorTree(node1.getLeft(), node2.getRight())
                    && isMirrorTree(node1.getRight(), node2.getLeft());
        }

        return false;
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        System.out.println("Tree 1: ");
        LevelOrderTraversal.doLevelOrderTraversal(node);

        SimpleBinaryTreeNode mirror = MirrorTreeConvertor.toMirrorTree(TreeUtils.createSimpleBinaryTree());
        System.out.println("Tree 2: ");
        LevelOrderTraversal.doLevelOrderTraversal(mirror);

        boolean isMirror = isMirrorTree(node, mirror);
        if (isMirror) {
            System.out.println("Two trees are mirrors..");
        } else {
            System.out.println("Two trees are not mirrors..");
        }
    }

}
