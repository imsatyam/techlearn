package com.satyam.problem.leetcode.easy;

/**

 LC #28
 Implement strStr().
 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Idea:
    Keep an eye on length of given string. If all is well, check substring.
    Why strStr() ? http://www.cplusplus.com/reference/cstring/strstr/

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286625909/
    Runtime: 0 ms
    Memory: 37.7 MB

 */

public class LC28NeedleInHaystackOrStrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int index = 0; index <= haystack.length() - needle.length(); index++) {
            if (haystack.substring(index, index + needle.length()).equals(needle)) {
                return index;
            }
        }

        return -1;
    }
}
