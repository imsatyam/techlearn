package com.satyam.problem.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 LC #282
 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 s(not unary) +, -, or * between the digits so they evaluate to the target value.

 Example 1:
 Input: num = "123", target = 6
 Output: ["1+2+3", "1*2*3"]

 Example 2:
 Input: num = "232", target = 8
 Output: ["2*3+2", "2+3*2"]

 Example 3:
 Input: num = "105", target = 5
 Output: ["1*0+5","10-5"]

 Example 4:
 Input: num = "00", target = 0
 Output: ["0+0", "0-0", "0*0"]

 Example 5:
 Input: num = "3456237490", target = 9191
 Output: []

 Idea:
     Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291756809/
    Runtime: 131 ms
    Memory: 49 MB

 */

public class LC282ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return Collections.emptyList();
        }

        List<String> results = new ArrayList<>();
        addOperators(results, "", num, target, 0, 0, 0);
        return results;
    }

    private void addOperators(List<String> results, String currExpr, String input, int target,
                              int pos, long currVal, long last) {

        if (pos == input.length()) {
            if (currVal == target) {
                results.add(currExpr);
            }
            return;
        }

        for (int i = pos; i < input.length(); i++) {

            //ignore case which start with 0 as they are useless for evaluation
            if (i != pos && input.charAt(pos) == '0') {
                break;
            }

            // take part of input from position to i and convert to numeric
            String part = input.substring(pos, i + 1);
            long curr = Long.parseLong(part);

            // if pos is 0, send numeric value for next recursion
            if (pos == 0) {
                addOperators(results, currExpr + part, input, target, i + 1, curr, curr);
            } else {
                addOperators(results, currExpr + "+" + part, input, target,
                        i + 1, currVal + curr, curr);
                addOperators(results, currExpr + "-" + part, input, target,
                        i + 1, currVal - curr, -curr);
                addOperators(results, currExpr + "*" + part, input, target,
                        i + 1, currVal - last + last * curr, last * curr);
            }
        }
    }
}
