package com.satyam.problem.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**

 LC #118
 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle

 Idea:
 We know that ith entry in a line number line is Binomial Coefficient C(line, i) and all lines start with value 1.
 The idea is to calculate C(line, i) using C(line, i-1):
    C(line, i) = C(line, i-1) * (line - i + 1) / i

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286663078/
    Runtime: 0 ms
    Memory: 34.1 MB

 */

public class LC118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        for (int line = 1; line <= numRows; line++) {

            int c = 1;
            list.add(new ArrayList<>());

            for (int i = 1; i <= line; i++) {
                list.get(line - 1).add(c);
                c = c * (line - i) / i;
            }
        }

        return list;
    }

}
