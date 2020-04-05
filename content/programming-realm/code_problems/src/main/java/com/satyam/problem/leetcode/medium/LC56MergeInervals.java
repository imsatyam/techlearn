package com.satyam.problem.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**

 LC #56
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

 Idea:
    Sort the intrval on start time
    Use linked list to get the interval merged

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279223291/
    Runtime: 7 ms
    Memory: 43.2 MB

 */

public class LC56MergeInervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        List<Interval> intervalList = toIntervalList(intervals);
        Collections.sort(intervalList);

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalList) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return toIntervalArr(merged);
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
