package com.satyam.problem.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**

 LC #57
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 Idea:
    Use dp where dp[i][j] represents the result of matching string[0...i] and pattern[0...j]

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279469734/
    Runtime: 4 ms
    Memory: 41.7 MB

 */

public class LC57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return new int[][]{};
        }

        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        List<Interval> intervalList = toIntervalList(intervals);
        Interval nInterval = new Interval(newInterval[0], newInterval[1]);

        List<Interval> result = new ArrayList<>();
        for (Interval i : intervalList) {
            if (nInterval == null || i.end < nInterval.start) {
                result.add(i);
            } else if (i.start > nInterval.end) {
                result.add(nInterval);
                nInterval = null;
                result.add(i);
            } else {
                nInterval.start = Math.min(nInterval.start, i.start);
                nInterval.end = Math.max(nInterval.end, i.end);
            }
        }

        if (nInterval != null) {
            result.add(nInterval);
        }

        return toIntervalArr(result);
    }

    private List<Interval> toIntervalList(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        return intervalList;
    }

    private int[][] toIntervalArr(List<Interval> intervalList) {
        int[][] arr = new int[intervalList.size()][2];
        int i = 0;
        for (Interval interval : intervalList) {
            arr[i] = interval.toArr();
            i++;
        }
        return arr;
    }

    private static class Interval implements Comparable<Interval>{
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval a) {
            if (a == null) {
                return 1;
            }

            return this.start - a.start;
        }

        public int[] toArr() {
            return new int[]{this.start, this.end};
        }
    }

}
