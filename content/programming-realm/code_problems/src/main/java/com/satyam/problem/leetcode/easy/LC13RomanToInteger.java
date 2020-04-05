package com.satyam.problem.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**

 LC #13
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 Idea:
    Use hashmap to store number equivalent of roman variables.
    Then traverse the given string from end.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286653909/
    Runtime: 5 ms
    Memory: 36.1 MB

 */

public class LC13RomanToInteger {

    private static final Map<Character, Integer> romanIntegerMap = new HashMap<>();

    public LC13RomanToInteger() {
        romanIntegerMap.put('I', 1);
        romanIntegerMap.put('V', 5);
        romanIntegerMap.put('X', 10);
        romanIntegerMap.put('L', 50);
        romanIntegerMap.put('C', 100);
        romanIntegerMap.put('D', 500);
        romanIntegerMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sum = 0, prev = 0;
        int index = s.length() - 1;
        while (index >= 0) {
            char romanChar = s.charAt(index);
            int integerEqv = romanIntegerMap.get(romanChar);
            if (integerEqv >= prev) {
                sum += integerEqv;
            } else {
                sum -= integerEqv;
            }
            prev = integerEqv;
            index--;
        }
        return sum;
    }

}
