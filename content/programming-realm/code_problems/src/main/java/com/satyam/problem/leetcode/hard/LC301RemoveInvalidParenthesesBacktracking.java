package com.satyam.problem.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
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
    Count misplaced left or right parenthesis
    recurse by removing each of the misplaced ones

 Submission Detail
    Link: https://leetcode.com/submissions/detail/314774549/
    Runtime: 9 ms
    Memory: 31.9 MB

 Reference
    https://leetcode.com/problems/remove-invalid-parentheses/solution/

 */

public class LC301RemoveInvalidParenthesesBacktracking {

    public List<String> removeInvalidParentheses(String s) {
        if (s == null) {
            return Collections.emptyList();
        }

        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right = left == 0 ? right + 1 : right;
                left = (left > 0) ? left - 1 : left;
            }
        }

        Set<String> results = new HashSet<>();
        recurse(s, 0, 0, 0, left, right, new StringBuilder(), results);
        return new ArrayList<>(results);
    }

    private void recurse(
            String s, int index, int leftCount, int rightCount, int leftRem, int rightRem,
            StringBuilder expr, Set<String> results) {

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                results.add(expr.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if ((c == '(' && leftRem > 0) || c == ')' && rightRem > 0) {
            recurse(s, index+1, leftCount, rightCount,
                    leftRem - (c == '(' ? 1 : 0),
                    rightRem- (c == ')' ? 1 : 0),
                    expr, results);
        }

        int currLength = expr.length();
        expr.append(c);

        if (c != '(' && c != ')') {
            recurse(s, index+1, leftCount, rightCount, leftRem, rightRem, expr, results);
        } else if (c == '(') {
            recurse(s, index+1, leftCount + 1, rightCount, leftRem, rightRem, expr, results);
        } else if (rightCount < leftCount) {
            recurse(s, index+1, leftCount, rightCount + 1, leftRem, rightRem, expr, results);
        }

        expr.deleteCharAt(currLength);

    }

}
