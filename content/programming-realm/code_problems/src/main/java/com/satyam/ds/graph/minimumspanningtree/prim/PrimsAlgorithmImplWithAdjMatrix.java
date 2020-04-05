package com.satyam.ds.graph.minimumspanningtree.prim;

import java.util.HashSet;
import java.util.Set;

public class PrimsAlgorithmImplWithAdjMatrix {

    private static void primMST(int vertexCount, int[][] graph) {
        Set<Integer> visitedSet = new HashSet<>();      // To represent set of vertices not yet included in MST
        int[] keys = new int[vertexCount];         // Key values used to pick minimum weight edge in cut
        int[] mstResult = new int[vertexCount];    // Array to store constructed MST

        for (int v = 0; v < vertexCount; v++) {
            keys[v] = Integer.MAX_VALUE;
        }

        keys[0] = 0;
        mstResult[0] = -1;                          // First node is always root of MST

        for (int count = 0; count < vertexCount - 1; count++) {         // MST will have V vertices
            int minIndex = getMinKeyIndex(vertexCount, keys, visitedSet);
            visitedSet.add(minIndex);
            for (int vertex = 0; vertex < vertexCount; vertex++) {
                if (graph[minIndex][vertex] != 0
                        && !visitedSet.contains(vertex)
                        && graph[minIndex][vertex] < keys[vertex]) {
                    mstResult[vertex] = minIndex;
                    keys[vertex] = graph[minIndex][vertex];
                }
            }
        }

        printMST(mstResult, graph, vertexCount);
    }

    private static void printMST(int[] mstResult, int[][] graph, int vertexCount) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertexCount; i++) {
            System.out.println(mstResult[i] + " - " + i + "\t" + graph[i][mstResult[i]]);
        }
    }

    private static int getMinKeyIndex(int vertexCount, int[] keys, Set<Integer> mstSet) {
        int min = Integer.MAX_VALUE;
        int minKeyIndex = -1;

        for (int i = 0; i < vertexCount; i++) {
            if (!mstSet.contains(i) && keys[i] < min) {
                min = keys[i];
                minKeyIndex = i;
            }
        }
        return minKeyIndex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        primMST(5, graph);
    }
}
