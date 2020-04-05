package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 LC #17
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Idea:
    Use backtracking

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279228775/
    Runtime: 0 ms
    Memory: 36.2  MB

 */

public class LC17LetterCombinationsOfPhoneNumber {

    private static final Map<String, String> KEYPAD = new HashMap<>();

    public LC17LetterCombinationsOfPhoneNumber() {
        KEYPAD.put("2", "abc");
        KEYPAD.put("3", "def");
        KEYPAD.put("4", "ghi");
        KEYPAD.put("5", "jkl");
        KEYPAD.put("6", "mno");
        KEYPAD.put("7", "pqrs");
        KEYPAD.put("8", "tuv");
        KEYPAD.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return output;
        }

        doBacktracking(digits, "", output);
        return output;
    }

    private void doBacktracking(String digits, String combination, List<String> output) {
        if (digits.length() == 0) {
            output.add(combination);
            return;
        }

        String digit = digits.substring(0, 1);
        String letters = KEYPAD.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i+1);
            doBacktracking(digits.substring(1), combination + letter, output);
        }
    }
}
