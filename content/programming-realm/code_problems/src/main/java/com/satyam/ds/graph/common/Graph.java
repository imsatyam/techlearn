package com.satyam.ds.graph.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Simple graph class that can be used by different programs.
 */
public class Graph {
    private int vertexCount;
    private int edgeCount;
    private Node[] vertices;
    private Edge[] edges;

    public Graph(int vertexCount) {
        this(vertexCount, 0);
    }

    public Graph(int vertexCount, int edgeCount) {
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;

        if (vertexCount > 0) {
            this.vertices = new Node[vertexCount];
        }
        if (edgeCount > 0) {
            this.edges = new Edge[edgeCount];
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(int edgeCount) {
        this.edgeCount = edgeCount;
    }

    public Node[] getVertices() {
        return vertices;
    }

    public void setVertices(Node[] vertices) {
        this.vertices = vertices;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public void addNode(Node node) {
        if (Objects.isNull(vertices)) {
            throw new IllegalArgumentException("vertices array is null.");
        }
        if (node.getValue() >= vertices.length) {
            throw new IllegalArgumentException("Given index is greater than the length of vertices array.");
        }
        vertices[node.getValue()] = node;
    }

    public void addEdge(int index, Edge edge) {
        if (Objects.isNull(edges)) {
            throw new IllegalArgumentException("Edges array is null.");
        }
        if (index >= edges.length) {
            throw new IllegalArgumentException("Given index is greater than the length of edges array.");
        }
        edges[index] = edge;
    }

    public Node getNode(int index) {
        if (Objects.isNull(vertices)) {
            throw new IllegalArgumentException("vertices array is null.");
        }
        if (index >= vertices.length) {
            throw new IllegalArgumentException("Given index is greater than the length of vertices array.");
        }
        return vertices[index];
    }

    public Edge getEdge(int index) {
        if (Objects.isNull(edges)) {
            throw new IllegalArgumentException("Edges array is null.");
        }
        if (index >= edges.length) {
            throw new IllegalArgumentException("Given index is greater than the length of edges array.");
        }
        return edges[index];
    }

    public static class Node {
        private Integer value;
        private Integer weight;
        private List<Node> adjacencyList;

        public Node(int value) {
            this(value, null);
        }

        public Node(Integer value, Integer weight) {
            this.value = value;
            this.weight = weight;
            this.adjacencyList = new ArrayList<>();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public List<Node> getAdjacencyList() {
            return adjacencyList;
        }

        public void setAdjacencyList(List<Node> adjacencyList) {
            this.adjacencyList = adjacencyList;
        }

        public void addNode(Node node) {
            this.adjacencyList.add(node);
        }
    }

    public static class Edge implements Comparable<Edge> {
        private Node source;
        private Node destination;
        private int weight;

        public Edge() {
        }

        public Edge(Node source, Node destination) {
            this.source = source;
            this.destination = destination;
        }

        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Node getSource() {
            return source;
        }

        public Node getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setSource(Node source) {
            this.source = source;
        }

        public void setDestination(Node destination) {
            this.destination = destination;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
