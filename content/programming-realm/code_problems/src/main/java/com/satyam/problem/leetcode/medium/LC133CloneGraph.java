package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**

 LC #133
 Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 Idea:
    Use hashmap to create clone

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279515812/
    Runtime: 2 ms
    Memory: 33.1 MB

 */

public class LC133CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        q.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()) {
            Node actualNode = q.poll();
            Node clonedNode = map.get(actualNode);
            if (actualNode.neighbors != null) {
                for (Node neighbour : actualNode.neighbors) {
                    Node clonedNeighbour = map.get(neighbour);
                    if (clonedNeighbour == null) {
                        q.offer(neighbour);
                        clonedNeighbour = new Node(neighbour.val, new ArrayList<>());
                        map.put(neighbour, clonedNeighbour);
                    }
                    clonedNode.neighbors.add(clonedNeighbour);
                }
            }
        }
        return map.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
