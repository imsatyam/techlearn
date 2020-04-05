package com.satyam.problem.leetcode.medium;

/**

 LC #1143
 Given two strings text1 and text2, return the length of their longest common subsequence.

 A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted
 without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 A common subsequence of two strings is a subsequence that is common to both strings.

 If there is no common subsequence, return 0.

 Example 1:

 Input: text1 = "abcde", text2 = "ace"
 Output: 3
 Explanation: The longest common subsequence is "ace" and its length is 3.

 Idea:
    Use DP

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291771145/
    Runtime: 7 ms
    Memory: 35.7 MB

 */

public class LC1142LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] arr = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                }
                else if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[len1][len2];
    }

}
