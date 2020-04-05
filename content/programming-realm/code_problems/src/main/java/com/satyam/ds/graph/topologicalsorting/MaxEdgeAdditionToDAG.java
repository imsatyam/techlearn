package com.satyam.ds.graph.topologicalsorting;

import com.satyam.ds.graph.common.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**

 A DAG is given to us, we need to find maximum number of edges that can be added to this DAG, after which new graph
 still remain a DAG that means the reformed graph should have maximal number of edges, adding even single edge will
 create a cycle in graph.

 Idea:
 We sort all our nodes in topological order and create edges from node to all nodes to the right if not there already.

 */
public class MaxEdgeAdditionToDAG {

    private static void addMaximumEdgeWhilePreservingDAG(SimpleGraph graph) {
        Set<Integer> visitedSet = new HashSet<>();
        List<Integer> topologicalSortResult = KahnAlgorithmForTopologicalSorting.doTopologicalSorting(graph);
        for (int i = 0; i < topologicalSortResult.size(); i++) {

            int vertex = topologicalSortResult.get(i);
            List<Integer> adjacentNodes = graph.getAdjacencyList()[vertex];
            if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                for (int adjNode : adjacentNodes) {
                    visitedSet.add(adjNode);
                }
            }

            // left to right add any missing edge
            for (int j = i+1; j < topologicalSortResult.size(); j++) {
                int adjNode = topologicalSortResult.get(j);
                if (!visitedSet.contains(adjNode)) {
                    System.out.println( vertex + " - " + adjNode);
                }

                // clean up so that next iteration of i works seamlessly
                visitedSet.remove(adjNode);
            }
        }
    }

    public static void main(String[] args) {
        SimpleGraph g = new SimpleGraph(6);
        g.addEdge(5, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 2);
        addMaximumEdgeWhilePreservingDAG(g);
    }

}
