package com.satyam.problem.leetcode.easy;

/**

 LC #38
 The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively,
 in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

 Note: Each term of the sequence of integers will be represented as a string.

 Input: 1
 Output: "1"
 Explanation: This is the base case.

 Input: 4
 Output: "1211"
 Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means
 frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".

 Idea:
    Start with result string of 1. Count the frequency => then add frequency followed by the number itself.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279463350/
    Runtime: 2 ms
    Memory: 34.3 MB

 */

public class LC38CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        int i = 1;
        String res = "1";

        while (i < n) {

            StringBuilder builder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    builder.append(count);
                    builder.append(res.charAt(j - 1));
                    count = 1;
                }
            }

            builder.append(count);
            builder.append(res.charAt(res.length() - 1));
            res = builder.toString();

            i++;
        };

        return res;
    }

}
