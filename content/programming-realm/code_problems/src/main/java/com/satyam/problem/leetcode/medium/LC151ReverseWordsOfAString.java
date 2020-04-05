package com.satyam.problem.leetcode.medium;

/**

 LC #151
 Given an input string, reverse the string word by word
 Input: "the sky is blue"
 Output: "blue is sky the"

 Idea:
 Split using space i.e. "\\s+" and reverse using string builder

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286664669/
    Runtime: 6 ms
    Memory: 36.1 MB

 */

public class LC151ReverseWordsOfAString {

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }

        String[] arr = s.trim().split("\\s+");
        int index = arr.length - 1;
        StringBuilder builder = new StringBuilder();
        while (index > 0) {
            builder.append(arr[index]).append(" ");
            index--;
        }
        builder.append(arr[0]);
        return builder.toString();
    }

}
