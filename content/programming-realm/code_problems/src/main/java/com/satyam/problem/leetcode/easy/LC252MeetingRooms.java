package com.satyam.problem.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**

 LC #252
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false..

 Idea:
 If a meeting's end time is larger than another's start time, a person cannot attend both meetings.
 So the idea is to sort the array based on start time. Then we can iterate through the array to check if any
 two consecutive meetings overlap.

 Submission Detail
    - NA -

 Reference:
    https://www.youtube.com/watch?v=i2bBG7CaVxs

 */

public class LC252MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }

    static class Interval {
        int start;
        int end;
    }
}
