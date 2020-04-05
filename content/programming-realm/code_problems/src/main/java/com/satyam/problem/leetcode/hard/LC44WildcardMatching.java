package com.satyam.problem.leetcode.hard;

/**

 LC #44
 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Idea:
    Use dp where dp[i][j] represents the result of matching string[0...i] and pattern[0...j]

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279525158/
    Runtime: 10 ms
    Memory: 38 MB

 */

public class LC44WildcardMatching {

    public boolean isMatch(String s, String p) {

        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        // clean up patterns i.e. a**b => a*b
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if(isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        // apply DP
        boolean[][] dp = new boolean[str.length + 1][writeIndex + 1];
        dp[0][0] = true;
        if (writeIndex > 0 && pattern[0] == '*') {
            dp[0][1] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[str.length][writeIndex];
    }

}
