package com.satyam.ds.graph.topologicalsorting;

import com.satyam.ds.graph.common.GraphUtils;
import com.satyam.ds.graph.common.SimpleGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**

 The approach is based on the below fact :

 A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
 Proof: There’s a simple proof to the above fact is that a DAG does not contain a cycle which means that all paths will be of finite length.
 Now let S be the longest path from u(source) to v(destination). Since S is the longest path there can be no incoming edge to u and no outgoing edge from v,
 if this situation had occurred then S would not have been the longest path
 => indegree(u) = 0 and outdegree(v) = 0



 Algorithm:

 Steps involved in finding the topological ordering of a DAG:

 Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.

 Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

 Step-3: Remove a vertex from the queue (Dequeue operation) and then.

 Increment count of visited nodes by 1.
 Decrease in-degree by 1 for all its neighboring nodes.
 If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
 Step 5: Repeat Step 3 until the queue is empty.

 Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.



 Finding in-degree of a node:

 1) Traverse the array of edges and simply increase the counter of the destination node by 1.
     for each node in Nodes
        indegree[node] = 0;
     for each edge(src,dest) in Edges
        indegree[dest]++

 2) Traverse the list for every node and then increment the in-degree of all the nodes connected to it by 1
     for each node in Nodes
        If (list[node].size()!=0) then
     for each dest in list
        indegree[dest]++;

 */

public class KahnAlgorithmForTopologicalSorting {

    public static List<Integer> doTopologicalSorting(SimpleGraph graph) {
        int[] indegrees = GraphUtils.getIndegreeArray(graph);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topologicalSortResult = new ArrayList<>();

        for (int v = 0; v < graph.getVertices(); v++) {
            if (indegrees[v] == 0) {
                queue.add(v);
            }
        }

        int visitedNodeCount = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalSortResult.add(node);

            List<Integer> adjacentNodes = graph.getAdjacencyList()[node];
            if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                for (int vertex : adjacentNodes) {
                    indegrees[vertex]--;
                    if (indegrees[vertex] == 0) {
                        queue.add(vertex);
                    }
                }
            }

            visitedNodeCount++;
        }

        return visitedNodeCount == graph.getVertices() ? topologicalSortResult : null;
    }

    public static void main(String[] args) {
        SimpleGraph g=new SimpleGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        List<Integer> topologicalSortResult = doTopologicalSorting(g);

        if (Objects.isNull(topologicalSortResult)) {
            System.out.println("There exists a cycle in the graph");
        } else {
            for (int i : topologicalSortResult) {
                System.out.print(i + " ");
            }
        }
    }

}
