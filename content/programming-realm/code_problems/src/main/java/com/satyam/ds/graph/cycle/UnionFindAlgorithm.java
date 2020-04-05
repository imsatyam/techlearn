package com.satyam.ds.graph.cycle;

import com.satyam.ds.graph.common.Graph;

/**

 A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
 A union-find algorithm is an algorithm that performs two useful operations on such a data structure:

 Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.

 Union: Join two subsets into a single subset.

 Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not.

 This method assumes that the graph doesn’t contain any self-loops.

 Reference: https://www.geeksforgeeks.org/union-find/

 */
public class UnionFindAlgorithm {

    private boolean hasCycle(Graph graph) {
        int[] parents = new int[graph.getVertexCount()];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = -1;
        }

        for (int e = 0; e < graph.getEdgeCount(); e++) {
            Graph.Edge edge = graph.getEdge(e);
            int x = find(parents, edge.getSource().getValue());
            int y = find(parents, edge.getDestination().getValue());
            if (x == y) {
                return true;
            }
            union(parents, x, y);
        }

        return false;
    }

    private static int find(int[] parents, int node) {
        if (parents[node] == -1) {
            return node;
        }
        return find(parents, parents[node]);
    }

    private static void union(int[] parents, int x, int y) {
        int xSet = find(parents, x);
        int ySet = find(parents, y);
        parents[xSet] = ySet;
    }
}
