package com.satyam.ds.graph.traversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 time complexity: O(V+E)
 */
public class BreadthFirstTraversalWithAdjacencyMtx {

    private static void doBFSTraversal(int[][] mtx, int source) {
        Set<Integer> visitedSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedSet.add(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int index = 0; index < mtx.length; index++) {
                if (mtx[vertex][index] == 1 && !visitedSet.contains(index)) {
                    visitedSet.add(index);
                    queue.add(index);
                }
            }
        }
    }

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 1 },
                { 0, 1, 1, 1, 0 }
        };
        doBFSTraversal(graph, 2);
    }

}
