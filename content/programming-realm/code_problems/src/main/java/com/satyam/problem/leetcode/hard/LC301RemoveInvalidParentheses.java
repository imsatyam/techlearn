package com.satyam.problem.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**

 LC #301
 Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Example 1:
 Input: "()())()"
 Output: ["()()()", "(())()"]

 Example 2:
 Input: "(a)())()"
 Output: ["(a)()()", "(a())()"]

 Example 3:
 Input: ")("
 Output: [""]

 Idea:
     Using breadth first search technique
     The idea is straightforward, with the input string s, we generate all possible states by removing
     one '(' or ')', check if they are valid, if found valid ones on the current level, put them to the
     final result list and we are done, otherwise, add them to a queue and carry on to the next level.
     The good thing of using BFS is that we can guarantee the number of parentheses that need to be
     removed is minimal, also no recursion call is needed in BFS.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291610812/
    Runtime: 51 ms
    Memory: 39.9 MB

 Reference
    https://leetcode.com/problems/remove-invalid-parentheses/solution/

 */

public class LC301RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {

        List<String> results = new ArrayList<>();
        if (s == null) return results;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean foundAtLevel = false;

        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValidExpression(s)) {
                results.add(s);
                foundAtLevel = true;
            }

            if (foundAtLevel) {
                continue;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return results;
    }

    boolean isValidExpression(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
