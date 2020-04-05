package com.satyam.problem.leetcode.medium;

/**

 LC #161
 Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
 Expected time complexity is O(m+n) where m and n are lengths of two strings.

 Idea:
     If | n - m | is greater than 1, we know immediately both are not one-edit distance apart.
     2. It might help if you consider these cases separately, m == n and m ≠ n.
     3. Assume that m is always ≤ n, which greatly simplifies the conditional statements. If m > n, we could just simply swap S and T.
     4. If m == n, it becomes finding if there is exactly one modified operation. If m ≠ n, you do not have to consider the delete operation.
     Just consider the insert operation in T.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279475544/
    Runtime: 0 ms
    Memory: 37.4 MB

 */

public class LC161OneEditDistance {

    public boolean isOneEditDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (Math.abs(m - n) > 1)
            return false;

        int count = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) {
                    return false;
                }

                if (m > n)
                    i++;
                else if (m < n)
                    j++;
                else {
                    i++;
                    j++;
                }
                count++;
            } else {
                i++;
                j++;
            }
        }

        if (i < m || j < n) {
            count++;
        }

        return count == 1;
    }

}
