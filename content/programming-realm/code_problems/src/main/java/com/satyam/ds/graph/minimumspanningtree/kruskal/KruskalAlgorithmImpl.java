package com.satyam.ds.graph.minimumspanningtree.kruskal;

import com.satyam.ds.graph.common.Graph;

import java.util.Arrays;

public class KruskalAlgorithmImpl {

    private static void kruskalMST(Graph graph) {
        Graph.Edge[] mstResult = new Graph.Edge[graph.getVertexCount()];
        ParentEntry[] parentEntries = new ParentEntry[graph.getVertexCount()];

        for (int i = 0; i < graph.getVertexCount(); i++) {
            mstResult[i] = new Graph.Edge();
            parentEntries[i] = new ParentEntry(i, 0);
        }

        Arrays.sort(graph.getEdges());

        int index = 0;
        int edge = 0;
        while (edge < graph.getVertexCount() - 1) {
            Graph.Edge nextEdge = graph.getEdge(index);
            int parentX = find(parentEntries, nextEdge.getSource().getValue());
            int parentY = find(parentEntries, nextEdge.getDestination().getValue());
            if (parentX != parentY) {
                mstResult[edge] = nextEdge;
                union(parentEntries, parentX, parentY);
                edge++;
            }
            index++;
        }

        for (int i = 0; i < edge; i++) {
            System.out.println(mstResult[i].getSource().getValue() + " -- "
                    + mstResult[i].getDestination().getValue()
                    + " == " + mstResult[i].getWeight());
        }
    }

    private static int find(ParentEntry[] entries, int vertex) {
        if (entries[vertex].parent == vertex) {
            return entries[vertex].parent;
        }
        return find(entries, entries[vertex].parent);
    }

    private static void union(ParentEntry[] entries, int x, int y) {
        int parentX = find(entries, x);
        int parentY = find(entries, y);

        if (entries[parentX].rank < entries[parentY].rank) {
            entries[parentX].parent = parentY;
        } else if (entries[parentX].rank > entries[parentY].rank) {
            entries[parentY].parent = parentX;
        } else {
            entries[parentY].parent = parentX;
            entries[parentX].rank++;
        }
    }

    public static void main (String[] args) {
        int vertexCount = 4;
        int edgeCount = 5;
        Graph graph = new Graph(vertexCount, edgeCount);
        graph.addEdge(0, new Graph.Edge(new Graph.Node(0), new Graph.Node(1), 10));
        graph.addEdge(1, new Graph.Edge(new Graph.Node(0), new Graph.Node(2), 6));
        graph.addEdge(2, new Graph.Edge(new Graph.Node(0), new Graph.Node(3), 5));
        graph.addEdge(3, new Graph.Edge(new Graph.Node(1), new Graph.Node(3), 15));
        graph.addEdge(4, new Graph.Edge(new Graph.Node(2), new Graph.Node(3), 4));
        kruskalMST(graph);
    }

    static class ParentEntry {
        private int parent;
        private int rank;

        public ParentEntry() {
        }

        public ParentEntry(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    };

}
