package com.satyam.algorithm.backtracking;

/**

Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that
no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment
of colors to all vertices.

Input:
1) A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph.
   A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.

2) An integer m which is the maximum number of colors that can be used.

Output:
An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex.
The code should also return false if the graph cannot be colored with m colors.

 */

public class MColoringProblem {

    private static final int V = 4;
    private static final int MAX_COLORS = 3;

    private static boolean isGraphColored(int[][] graph, int colorCount) {
        int[] colors = new int[V];
        for (int i = 0; i < V; i++) {
            colors[i] = 0;
        }

        if (isGraphColored(graph, colorCount, colors, 0)) {
            printSolution(colors);
            return true;
        }
        System.out.println("Could not color graph...");
        return false;
    }


    private static boolean isGraphColored(int[][] graph, int colorCount, int[] colors, int vertex) {

        if (vertex == V) {
            return true;
        }

        for (int color = 1; color <= colorCount; color++) {
            if (isSafe(graph, vertex, colors, color)) {
                colors[vertex] = color;
                if (isGraphColored(graph, colorCount, colors, vertex + 1)) {
                    return true;
                }
                colors[vertex] = 0;
            }
        }
        return false;
    }


    private static boolean isSafe(int[][] graph, int vertex, int[] colors, int color) {

        // no connected node can have same color
        for (int v = 0; v < V; v++) {
            if (graph[vertex][v] == 1 && colors[v] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };

        isGraphColored(graph, MAX_COLORS);
    }


    private static void printSolution(int[] colors) {
        for (int i = 0; i < V; i++) {
            System.out.print(colors[i] + "\t");
        }
        System.out.println("");
    }

}
