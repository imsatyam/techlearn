package com.satyam.ds.graph.common;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class GraphUtils {

    public static int[][] getGraphAdjacencyList(int a) {

        Collections.newSetFromMap(new ConcurrentHashMap<>());

        Queue<Integer> q = new LinkedList<>();
        q.offer(null);
        return null;
    }

    public static int[] getIndegreeArray(SimpleGraph graph) {
        int[] indegreeArr = new int[graph.getVertices()];
        for (int v = 0; v < graph.getVertices(); v++) {
            List<Integer> adjacentNodes = graph.getAdjacencyList()[v];
            if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                for (int node : adjacentNodes) {
                    indegreeArr[node]++;
                }
            }
        }
        return indegreeArr;
    }

}
