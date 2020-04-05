package com.satyam.ds.graph.traversal;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
    time complexity: O(V+E)
 */
public class RecursiveDepthFirstTraversalWithAdjacencyList {

    private static void doDFSTraversal(SimpleGraph graph) {
        Set<Integer> visitedSet = new HashSet<>();
        for (int i = 0; i < graph.getVertices(); ++i) {
            if (!visitedSet.contains(i)) {
                traverse(graph, i, visitedSet);
            }
        }
    }

    private static void traverse(SimpleGraph graph, int node, Set<Integer> visitedSet) {
        visitedSet.add(node);
        System.out.print(node + " ");
        List<Integer> adjacentNodes = graph.getAdjacencyList()[node];
        if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
            adjacentNodes.stream()
                    .filter(v -> !visitedSet.contains(v))
                    .forEach(v -> {
                        traverse(graph, v, visitedSet);
                    });
        }
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(4);
        g.addEdge(0, 1);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 3);

        doDFSTraversal(g);
    }

}
