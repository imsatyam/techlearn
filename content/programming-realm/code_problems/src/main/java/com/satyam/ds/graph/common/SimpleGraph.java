package com.satyam.ds.graph.common;

import java.util.LinkedList;
import java.util.List;

public class SimpleGraph {

    private int vertices;
    private List<Integer>[] adjacencyList;

    public SimpleGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int vertex = 0; vertex < vertices; vertex++) {
            adjacencyList[vertex] = new LinkedList<>();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void addEdge(int fromVertex, int toVertex) {
        adjacencyList[fromVertex].add(toVertex);
    }
}
