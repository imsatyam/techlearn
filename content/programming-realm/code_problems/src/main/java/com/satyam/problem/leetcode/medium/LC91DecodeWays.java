package com.satyam.problem.leetcode.medium;

/**

 LC #91
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 Example 1:
 Input: "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).

 Example 2:
 Input: "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 Idea:
    Use dp where dp[i] represents number of ways to decode a string of size i

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279493063/
    Runtime: 2 ms
    Memory: 39 MB

 */

public class LC91DecodeWays {

    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() == 0) {
            return 1;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        if (s.length() == 1) {
            return dp[1];
        }

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

}
