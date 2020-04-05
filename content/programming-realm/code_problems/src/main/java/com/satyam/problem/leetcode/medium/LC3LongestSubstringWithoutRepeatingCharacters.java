package com.satyam.problem.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**

 LC #3
 Given a string, find the length of the longest substring without repeating characters.

 Example 1:
 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:
 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Idea:
    use sliding window with hashmap

 Submission Detail
    Link: https://leetcode.com/submissions/detail/309576790/
    Runtime: 6 ms
    Memory: 41.8 MB

 */

public class LC3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0, j = 0, result = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while (i < n && j < n) {

            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            result = Math.max(result, j - i + 1);
            map.put(c, j + 1);
            j++;
        }

        return result;
    }

}
