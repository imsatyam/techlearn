package com.satyam.ds.graph.topologicalsorting;

import com.satyam.ds.graph.common.GraphUtils;
import com.satyam.ds.graph.common.SimpleGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**

 Uses Kahn Algorithm of topological sorting in an recursive manner.

 */
public class AllTopologicalSortCombinations {

    private static void listAllTopologicalSorts(SimpleGraph graph) {
        Set<Integer> visitedSet = new HashSet<>();
        int[] indegreeArr = GraphUtils.getIndegreeArray(graph);
        List<Integer> resultList = new ArrayList<>();
        listAllTopologicalSorts(graph, indegreeArr, visitedSet, resultList);
    }

    private static void listAllTopologicalSorts(SimpleGraph graph, int[] indegreeArr, Set<Integer> visitedSet, List<Integer> resultList) {

        boolean hasTopologicalSort = false;
        for (int v = 0; v < graph.getVertices(); v++) {

            if (!visitedSet.contains(v) && indegreeArr[v] == 0) {
                visitedSet.add(v);
                resultList.add(v);

                List<Integer> adjacentNodes = graph.getAdjacencyList()[v];
                if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                    for (int node : adjacentNodes) {
                        indegreeArr[node]--;
                    }
                }

                listAllTopologicalSorts(graph, indegreeArr, visitedSet, resultList);

                visitedSet.remove(v);
                resultList.remove(resultList.size() - 1);
                if (Objects.nonNull(adjacentNodes) && !adjacentNodes.isEmpty()) {
                    for (int node : adjacentNodes) {
                        indegreeArr[node]++;
                    }
                }

                hasTopologicalSort = true;
            }
        }

        if (!hasTopologicalSort) {
            resultList.forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        listAllTopologicalSorts(graph);
    }
}
