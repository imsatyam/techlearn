package com.satyam.ds.graph.traversal;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 time complexity: O(V+E)
 */
public class IterativeDepthFirstTraversalWithAdjacencyList {

    private static void doDFSTraversal(SimpleGraph graph) {
        Set<Integer> visitedSet = new HashSet<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!visitedSet.contains(i)) {
                traverse(graph, i, visitedSet);
            }
        }
    }

    private static void traverse(SimpleGraph graph, int source, Set<Integer> visitedSet) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visitedSet.add(source);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");
            List<Integer> adjacentNodes = graph.getAdjacencyList()[vertex];
            if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                adjacentNodes.stream()
                        .filter(v -> !visitedSet.contains(v))
                        .forEach(v -> {
                            visitedSet.add(v);
                            stack.push(v);
                        });
            }
        }
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        doDFSTraversal(g);
    }

}
