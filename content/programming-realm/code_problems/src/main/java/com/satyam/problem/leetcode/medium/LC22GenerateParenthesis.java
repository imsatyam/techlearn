package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 LC #22
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 Idea:
    Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/309450099/
    Runtime: 1 ms
    Memory: 39.7 MB

 */

public class LC22GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String curr, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(curr);
            return;
        }

        if (left > 0) {
            generateParenthesis(result, curr + "(", left - 1, right);
        }

        if (right > 0) {
            generateParenthesis(result, curr + ")", left, right - 1);
        }
    }
}
