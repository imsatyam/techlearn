package com.satyam.ds.graph.topologicalsorting;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 We can modify DFS to find Topological Sorting of a graph.

 In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices.

 In topological sorting, we use a temporary stack.
 We don’t print the vertex immediately, we first recursively call topological sorting for all its adjacent vertices,
 then push it to a stack. Finally, print contents of stack. Note that a vertex is pushed to stack only when all of its
 adjacent vertices (and their adjacent vertices and so on) are already in stack.

 Time complexity: O(V+E)
 */
public class DFSBasedTopologicalSorting {

    private static void applyTopologicalSort(SimpleGraph graph) {
        Set<Integer> visitedSet = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
            if (!visitedSet.contains(vertex)) {
                traverse(graph, vertex, stack, visitedSet);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void traverse(SimpleGraph graph, int vertex, Stack<Integer> stack, Set<Integer> visitedSet) {
        visitedSet.add(vertex);

        List<Integer> adjacentNodes = graph.getAdjacencyList()[vertex];
        if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
            adjacentNodes.stream()
                    .filter(v -> !visitedSet.contains(v))
                    .forEach(v -> {
                        traverse(graph, v, stack, visitedSet);
                    });
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        applyTopologicalSort(g);
    }
}
