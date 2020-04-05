package com.satyam.problem.leetcode.hard;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**

 LC #128
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 Your algorithm should run in O(n) complexity.

 Example:
 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 Idea:
    - Use hashset to see if next numbers are present in it.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279516390/
    Runtime: 11 ms
    Memory: 38.8 MB

 */

public class LC128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        int longestStreak = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
