package com.satyam.problem.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**

 LC #218
 A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 write a program to output the skyline formed by these buildings collectively

 Input:
 the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]

 Output:
 It should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline.
 For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be
 merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

 Idea:
 - Use a priority queue / treemap to store the building point.
 - Sorting idea
 - first compare by x.
 - If they are same then use this logic
 - if two starts are compared then higher height building should be picked first
 - if two ends are compared then lower height building should be picked first
 - if one start and end is compared then start should appear before end

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291439049/
    Runtime: 18 ms
    Memory: 42.1 MB

 Reference
    https://www.youtube.com/watch?v=GSBLe8cKu0s

 */

public class LC218SkylineSilhouetteProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return Collections.emptyList();
        }

        List<BuildingPoint> pointList = new ArrayList<>(buildings.length * 2);

        for (int[] building : buildings) {
            pointList.add(new BuildingPoint(building[0], building[2], true));
            pointList.add(new BuildingPoint(building[1], building[2], false));
        }

        Collections.sort(pointList);

        int previousHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);

        for (BuildingPoint bp : pointList) {
            if (bp.start) {
                queue.compute(bp.h, (k,v) -> {
                    if (v != null) {
                        return v + 1;
                    }
                    return 1;
                });
            } else {
                queue.compute(bp.h, (k,v) -> {
                    if (v == 1) {
                        return null;
                    }
                    return v - 1;
                });
            }

            int currentHeight = queue.lastKey();
            if (previousHeight != currentHeight) {
                result.add(Arrays.asList(bp.x, currentHeight));
                previousHeight = currentHeight;
            }
        }
        return result;
    }

    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int h;
        boolean start;

        public BuildingPoint(int x, int h, boolean start) {
            this.x = x;
            this.h = h;
            this.start = start;
        }

        @Override
        public  int compareTo(BuildingPoint b) {
            if (this.x != b.x) {
                return this.x - b.x;
            }
            return (this.start ? -this.h : this.h) - (b.start ? -b.h : b.h);
        }
    }

}
