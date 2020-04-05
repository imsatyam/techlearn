package com.satyam.ds.graph.cycle;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given an undirected graph, how to check if there is a cycle in the graph?
 For example, the following graph has a cycle 1-0-2-1.

 union-find algorithm can be used for cycle detection in undirected graphs.
 The time complexity of the union-find algorithm is O(ELogV)


 we can use DFS to detect cycle in an undirected graph in O(V+E) time. We do a DFS traversal of the given graph. For
 every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v,
 then there is a cycle in graph.

 */

public class UndirectedGraphCycle {

    private static boolean hasCycle(SimpleGraph graph) {
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (hasCycle(graph, i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(SimpleGraph graph, int vertex, Set<Integer> visited, int parentVertex) {
        if (visited.contains(vertex)) {
            return false;
        }

        visited.add(vertex);

        List<Integer> adjNodes = graph.getAdjacencyList()[vertex];
        if (adjNodes != null) {
            for (Integer node : adjNodes) {
                if (!visited.contains(node)) {
                    if (hasCycle(graph, vertex, visited, vertex)) {
                        return true;
                    }
                } else if (node != parentVertex) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(4);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        boolean hasCycle = hasCycle(graph);
        System.out.println("Graph has cycle. True or False?   " + hasCycle);

        SimpleGraph g2 = new SimpleGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        hasCycle = hasCycle(g2);
        System.out.println("G2 has cycle. True or False?   " + hasCycle);
    }

}
