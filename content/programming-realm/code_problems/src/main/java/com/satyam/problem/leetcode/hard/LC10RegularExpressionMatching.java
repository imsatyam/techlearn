package com.satyam.problem.leetcode.hard;

/**

 LC #10
 Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.

 Idea:
    Use dp

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291469270/
    Runtime: 1 ms
    Memory: 35.6 MB

 */

public class LC10RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean dp[][] = new boolean[text.length + 1][pattern.length + 1];

        dp[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern[i-1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][pattern.length];

    }

}
