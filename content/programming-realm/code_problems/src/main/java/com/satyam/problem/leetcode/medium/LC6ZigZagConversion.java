package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**

 LC #6
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"

 Idea:
    use lists and string builder

 Submission Detail
    Link: https://leetcode.com/submissions/detail/312085935/
    Runtime: 6 ms
    Memory: 42.9 MB

 */

public class LC6ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(i, new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            list.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow = currentRow + (goingDown ? 1 : -1);
        }

        StringBuilder builder = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            builder.append(list.get(i).toString());
        }
        return builder.toString();

    }

}
