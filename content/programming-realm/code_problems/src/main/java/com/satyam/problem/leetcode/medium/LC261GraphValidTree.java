package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**

 LC #261
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.
 For example:
 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
 is the same as [1, 0]and thus will not appear together in edges.

 Idea:
    An undirected graph is tree if it has following properties.
    1) There is no cycle.
    2) The graph is connected.

 Submission Detail
    - NA -

 Reference
    https://www.geeksforgeeks.org/check-given-graph-tree/

 */

public class LC261GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);
        int nodes = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;

            for (int neighbor : graph.get(node)) {
                if (queue.contains(neighbor)) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }
}
