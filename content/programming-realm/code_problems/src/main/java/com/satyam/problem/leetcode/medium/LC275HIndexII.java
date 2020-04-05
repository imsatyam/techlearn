package com.satyam.problem.leetcode.medium;

/**

 LC #275
 Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
 write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at
 least h citations each, and the other N − h papers have no more than h citations each."

 Example:

 Input: citations = [0,1,3,5,6]
 Output: 3

 Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 received 0, 1, 3, 5, 6 citations respectively.

 Since the researcher has 3 papers with at least 3 citations each and the remaining
 two with no more than 3 citations each, her h-index is 3.

 Idea:
    Use binary search

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279289289/
    Runtime: 0 ms
    Memory: 44.6 MB

 */

public class LC275HIndexII {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (citations[mid] < n - mid) {
                low = mid + 1;
            } else if (citations[mid] > n - mid) {
                high = mid;
            } else {
                return n - mid;
            }
        }

        if (low < n && citations[low] >= n - low) {
            return n - low;
        } else {
            return 0;
        }
    }

}
