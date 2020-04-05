package com.satyam.problem.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**

 LC #253
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 find the minimum number of conference rooms required.
 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2

 Idea:
 The idea is to first sort the array based on start time, so we can examine the meetings as they take place in order (and be greedy).
 Suppose we have three meetings: [0, 30], [5, 10], and [15, 20] in sorted order. When we see the second meeting,
 we check if its start time is later than the first meeting's end time. It's not, so we need another room.
 We then compare the third meeting's start time with the minimum of first two meetings' end times.
 If there is a meeting that ends before the third meeting starts, then we don't need another room.
 So as we iterate through the array, we need to store each meeting's end time and get the minimum quickly. Min heap is a natural choice..

 Submission Detail
    - NA -

 Reference:
    https://www.youtube.com/watch?v=PWgFnSygweI

 */

public class LC253MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Interval i : intervals) {
            if (!heap.isEmpty() && i.start >= heap.peek()) {
                heap.poll();
            }
            heap.offer(i.end);
        }
        return heap.size();
    }

    static class Interval {
        int start;
        int end;
    }
}
