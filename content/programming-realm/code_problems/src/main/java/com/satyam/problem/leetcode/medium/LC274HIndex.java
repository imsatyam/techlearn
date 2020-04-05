package com.satyam.problem.leetcode.medium;

import java.util.Arrays;

/**

 LC #274
 Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [3,0,6,1,5]
 Output: 3
 Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 received 3, 0, 6, 1, 5 citations respectively.
 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.
 Note: If there are several possible values for h, the maximum one is taken as the h-index.

 Idea:
    Sort the array and then
    traverse from right to left checking citations[i] >= citations.length-i

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279287675/
    Runtime: 1 ms
    Memory: 37.1 MB

 */

public class LC274HIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= citations.length-i) {
                h++;
            } else {
                break;
            }
        }

        return h;
    }

}
