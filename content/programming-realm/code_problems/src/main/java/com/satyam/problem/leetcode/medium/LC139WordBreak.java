package com.satyam.problem.leetcode.medium;

import java.util.List;

/**

 LC #139
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 segmented into a space-separated sequence of one or more dictionary words.

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".

 Idea:
    Use dp

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279518529/
    Runtime: 4 ms
    Memory: 36.1 MB

 */

public class LC139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
