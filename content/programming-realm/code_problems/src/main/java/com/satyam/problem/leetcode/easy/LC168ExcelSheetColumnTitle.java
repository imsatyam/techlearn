package com.satyam.problem.leetcode.easy;

/**

 LC #168
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...

 Example 1:
 Input: 1
 Output: "A"

 Example 2:
 Input: 28
 Output: "AB"

 Example 3:
 Input: 701
 Output: "ZY"

 Idea:
 Suppose we have a number n, let’s say 28. so corresponding to it we need to print the column name. We need to take remainder with 26.
 If remainder with 26 comes out to be 0 (meaning 26, 52 and so on) then we put ‘Z’ in the output string
 and new n becomes n/26 -1 because here we are considering 26 to be ‘Z’ while in actual it’s 25th with respect to ‘A’.

 Similarly if the remainder comes out to be non zero. (like 1, 2, 3 and so on) then we need to just insert the char
 accordingly in the string and do n = n/26.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291424217/
    Runtime: 0 ms
    Memory: 33.7 MB

 */

public class LC168ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder columnName = new StringBuilder();

        while (n > 0)
        {
            // Find remainder
            int rem = n % 26;

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0)
            {
                columnName.append("Z");
                n = (n / 26) - 1;
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                n = n / 26;
            }
        }

        // Reverse the string and print result
        return columnName.reverse().toString();
    }

}
