package com.satyam.ds.tree.traversal;

import com.satyam.ds.tree.common.SimpleBinaryTreeNode;
import com.satyam.ds.tree.common.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Use hashmap
 */
public class DiagonalTraversal {

    private static void doDiagonalTraversal(SimpleBinaryTreeNode node) {
        Map<Integer, List<SimpleBinaryTreeNode>> diagonalMap = new HashMap<Integer, List<SimpleBinaryTreeNode>>();
        printDiagonally(node, 0, diagonalMap);
        for(Map.Entry<Integer, List<SimpleBinaryTreeNode>> entry : diagonalMap.entrySet()) {
            entry.getValue().stream().forEach(nd -> System.out.print(nd.getValue() + " "));
        }
    }

    private static void printDiagonally(SimpleBinaryTreeNode node, int distance, Map<Integer, List<SimpleBinaryTreeNode>> diagonalMap) {
        if (null == node) {
            return;
        }

        if (!diagonalMap.containsKey(distance)) {
            diagonalMap.put(distance, new ArrayList<>());
        }

        diagonalMap.get(distance).add(node);

        printDiagonally(node.getLeft(), distance + 1, diagonalMap); // distance increases towards left
        printDiagonally(node.getRight(), distance, diagonalMap);
    }

    public static void main(String[] args) {
        SimpleBinaryTreeNode node = TreeUtils.createSimpleBinaryTree();
        doDiagonalTraversal(node);
    }
}
