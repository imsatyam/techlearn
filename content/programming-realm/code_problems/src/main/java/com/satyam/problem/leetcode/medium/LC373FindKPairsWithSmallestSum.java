package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**

 LC #373
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 Output: [[1,2],[1,4],[1,6]]
 Explanation: The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:

 Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 Output: [1,1],[1,1]
 Explanation: The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Idea:
 Use priority queue

 Submission Detail
    Link: https://leetcode.com/submissions/detail/312227445/
    Runtime: 4 ms
    Memory: 41.6 MB

 */

public class LC373FindKPairsWithSmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k<=0) {
            return results;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int index = 0; index < Math.min(nums1.length, k); index++) {
            queue.add(new int[]{nums1[index], nums2[0], 0});
        }

        while (!queue.isEmpty() && k-- > 0) {
            int[] curr = queue.poll();
            results.add(Arrays.asList(curr[0], curr[1]));

            int newIndex = curr[2] + 1;
            if (newIndex >= nums2.length) {
                continue;
            }
            queue.add(new int[]{curr[0], nums2[newIndex], newIndex});
        }
        return results;
    }

}
