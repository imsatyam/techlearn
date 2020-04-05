package com.satyam.problem.leetcode.easy;

/**

 LC #125
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:
 Input: "A man, a plan, a canal: Panama"
 Output: true

 Example 2:
 Input: "race a car"
 Output: false

 Idea:
 Use two pointers one from beginning and another from end.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277259450/
    Runtime: 4 ms
    Memory: 37.5 MB

 */

public class LC125ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
