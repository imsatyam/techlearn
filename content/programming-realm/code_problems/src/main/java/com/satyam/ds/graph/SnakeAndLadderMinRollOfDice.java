package com.satyam.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**

 - Consider it as a directed graph where vertex count == number of cells
 - Now it is about finding the shortest path in graph
 - As each cell has equal weight wee can find shortest path using BFS
 - If there is snake or a ladder at vertex, adjacent node changes.

 */
public class SnakeAndLadderMinRollOfDice {

    private static int getMinimumRollOfDice(int[] mov, int N) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        Node curr = null;
        while(!queue.isEmpty()) {

            curr = queue.poll();

            if (curr.value == N - 1) {
                break;
            }

            for (int i = curr.value + 1; i <= curr.value + 6 && i < N; i++) {
                if (!visited.contains(i)) {
                    Node node = new Node(i, curr.distanceFromSource + 1);
                    visited.add(i);
                    if (mov[i] != -1) {
                        node.value = mov[i];
                    }
                    queue.add(node);
                }
            }
        }

        return curr.distanceFromSource;
    }

    public static void main(String[] args)
    {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " + getMinimumRollOfDice(moves, N));
    }

    public static class Node {
        int value;
        int distanceFromSource;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, int distanceFromSource) {
            this.value = value;
            this.distanceFromSource = distanceFromSource;
        }
    }

}
