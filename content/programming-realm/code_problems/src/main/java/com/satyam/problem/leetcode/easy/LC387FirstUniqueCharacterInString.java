package com.satyam.problem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**

 LC #387
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.

 Idea:
    Use Hashmap

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277088234/
    Runtime: 54 ms
    Memory: 37.8 MB

 */

public class LC387FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        if (s == null || s == "") {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charCountMap.containsKey(s.charAt(i))) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCountMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
