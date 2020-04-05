package com.satyam.ds.graph.cycle;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the
 given graph contains at least one cycle, else return false.
 For example, the following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your function must return true.

 Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree.
 There is a cycle in a graph only if there is a back edge present in the graph. A back edge is an edge that is from a
 node to itself (self-loop) or one of its ancestor in the tree produced by DFS.


 To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. If we
 reach a vertex that is already in the recursion stack, then there is a cycle in the tree. The edge that connects
 current vertex to the vertex in the recursion stack is a back edge.

 */

public class DirectedGraphCycle {

    private static boolean hasCycle(SimpleGraph graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int i = 0; i < graph.getVertices(); i++) {
            if (hasCycle(graph, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(SimpleGraph graph, int vertex, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(vertex)) {
            return true;
        }

        if (visited.contains(vertex)) {
            return false;
        }

        visited.add(vertex);
        recStack.add(vertex);

        List<Integer> adjNodes = graph.getAdjacencyList()[vertex];
        if (adjNodes != null) {
            for (Integer node : adjNodes) {
                if (hasCycle(graph, vertex, visited, recStack)) {
                    return true;
                }
            }
        }

        recStack.remove(vertex);
        return false;
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        boolean hasCycle = hasCycle(graph);
        System.out.println("Graph has cycle. True or False?   " + hasCycle);
    }

}
