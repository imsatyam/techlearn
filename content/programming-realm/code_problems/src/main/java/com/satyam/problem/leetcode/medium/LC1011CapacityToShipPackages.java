package com.satyam.problem.leetcode.medium;

/**

 LC #1011
 A conveyor belt has packages that must be shipped from one port to another within D days.

 The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the
 conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

 Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

 Example 1:
 Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 Output: 15
 Explanation:
 A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 1st day: 1, 2, 3, 4, 5
 2nd day: 6, 7
 3rd day: 8
 4th day: 9
 5th day: 10

 Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into
 parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

 Idea:
     If we have unlimited days, the answer will be max(weights).
     If we just have one day, the answer will be sum(weights).
     Now, we have an interval between max(weights) and sum(weights).
     sorted list or interval => we can use the binary search!
     This question is not very intuitive because the interval is not obvious to find and the weights are not sorted.
     It is difficult to come up with the binary search.

            The time complexity is O(N*log(sum(weights) — max(weights)))


 Submission Detail
    Link: https://leetcode.com/submissions/detail/312315209/
    Runtime: 8 ms
    Memory: 45.7 MB

 */

public class LC1011CapacityToShipPackages {

    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int days = 1;
            int wt = 0;
            int mid = left + (right - left) / 2;

            for (int weight : weights) {
                if (wt + weight > mid) {
                    days++;
                    wt = 0;
                }
                wt += weight;
            }

            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

}
