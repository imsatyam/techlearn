package com.satyam.ds.graph.traversal;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 time complexity: O(V+E)
 */
public class BreadthFirstTraversalWithAdjacencyList {

    private static void doBFSTraversal(SimpleGraph graph, int source) {
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedSet.add(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            List<Integer> adjacentNodes = graph.getAdjacencyList()[vertex];
            if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                adjacentNodes.stream()
                        .filter(v -> !visitedSet.contains(v))
                        .forEach(v -> {
                            visitedSet.add(v);
                            queue.add(v);
                        });
            }
        }
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        doBFSTraversal(g, 2);
    }

}
