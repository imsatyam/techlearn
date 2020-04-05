package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 LC #49
 Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 Note:
 All inputs will be in lowercase.
 The order of your output does not matter.

 Idea:
    Get frequency of each of the alphabet in each word.
    Use this a key to group anagrams together.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277555309/
    Runtime: 18 ms
    Memory: 42.9 MB

 */

public class LC49GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder("");
            for (int j = 0; j < count.length; j++) {
                builder.append("#");
                builder.append(count[j]);
            }
            String key = builder.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}
