package com.satyam.problem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**

 LC #20
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Idea:
    Use hashmap and stack

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277225531/
    Runtime: 2 ms
    Memory: 34.5 MB

 */

public class LC20ValidParenthesis {

    private Map<Character, Character> map;

    public LC20ValidParenthesis() {
        this.map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if ((!stack.isEmpty()) && map.containsKey(x)) {
                if (map.get(x) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(x);
            }
        }
        return stack.isEmpty();
    }

}
