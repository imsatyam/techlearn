package com.satyam.problem.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**

 LC #269
 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 Derive the order of letters in this language.

 Example 1:
 Given the following words in dictionary,
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 Example 2:
 Given the following words in dictionary,
 [
 "z",
 "x"
 ]
 The correct order is: "zx".

 Idea:
 Topological sort:
     Build graph:
         a map of character -> set of character.
        Also get in-degrees for each character. In-degrees will be a map of character -> integer.

    Topological sort:
     Loop through in-degrees. Offer the characters with in-degree of 0 to queue.
     While queue is not empty:
         Poll from queue. Append to character to result string.
         Decrease the in-degree of polled character's children by 1.
         If any child's in-degree decreases to 0, offer it to queue.
    At last, if result string's length is less than the number of vertices, that means there is a cycle in graph. The order is invalid.

 Submission Detail
    NA

 Reference
    https://www.youtube.com/watch?v=RPpnRavqb8g
    https://medium.com/@wangfengfight/leetcode-269-alien-dictionary-and-followups-77c0390629da
    https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html

 */

public class LC269AlienDictionary {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);
        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }

}
