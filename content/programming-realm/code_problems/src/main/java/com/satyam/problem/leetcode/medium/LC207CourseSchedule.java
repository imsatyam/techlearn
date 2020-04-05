package com.satyam.problem.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**

 LC #207
 There are a total of n courses you have to take, labeled from 0 to n-1.
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Input: 2, [[1,0]]
 Output: true

 Idea:
 Use queue along with precount

 Submission Detail
    Link: https://leetcode.com/submissions/detail/287974359/
    Runtime: 34 ms
    Memory: 45 MB

 */

public class LC207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int len = prerequisites.length;
        int[] prereqCounters = new int[numCourses];

        for (int i = 0; i < len; i++) {
            prereqCounters[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereqCounters[i] == 0) {
                queue.offer(i);
            }
        }

        int preCount = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.poll();

            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == top) {
                    prereqCounters[prerequisites[i][0]]--;
                    if (prereqCounters[prerequisites[i][0]] == 0) {
                        preCount++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return preCount == numCourses;
    }

}
