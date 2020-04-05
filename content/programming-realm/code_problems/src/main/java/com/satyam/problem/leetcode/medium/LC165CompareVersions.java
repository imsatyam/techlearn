package com.satyam.problem.leetcode.medium;

/**

 LC #165
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

 Input: version1 = "0.1", version2 = "1.1"
 Output: -1

 Input: version1 = "7.5.2.4", version2 = "7.5.3"
 Output: -1

 Idea:
 Use split("\\.") and then compare value at each index in both the arrays.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286666174/
    Runtime: 1 ms
    Memory: 34.3 MB

 */

public class LC165CompareVersions {

    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int size = Math.max(arr1.length, arr2.length);
        int index = 0;

        while(index < size) {

            int v1 = index >= arr1.length ? 0 : Integer.parseInt(arr1[index]);
            int v2 = index >= arr2.length ? 0 : Integer.parseInt(arr2[index]);

            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }

            index++;
        }

        return 0;
    }

}
