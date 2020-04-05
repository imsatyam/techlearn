package com.satyam.problem.leetcode.medium;

/**

 LC #277
 Suppose you are at a party withnpeople (labeled from0ton - 1) and among them, there may exist one celebrity.
 The definition of a celebrity is that all the othern - 1people know him/her but he/she does not know any of them.
 Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is
 to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity
 (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

 You are given a helper function bool knows(a, b)which tells you whether A knows B.
 Implement a functionint findCelebrity(n), your function should minimize the number of calls toknows.

 Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return-1.

 Idea:
    - The first pass is to pick out the candidate. If candidate knows i, then switch candidate.
    - The second pass is to check whether the candidate is real.

 Submission Detail
    - NA -

 Reference:
    https://www.youtube.com/watch?v=LZJBZEnoYLQ

 */

public class LC277FindTheCelebrity extends Relation {

    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i))
                celebrity = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != celebrity) {
                if (knows(celebrity, i) || !knows(i, celebrity))
                    return -1;
            }
        }
        return celebrity;
    }

}


// GIVEN BY LEETCODE
class Relation {
    public boolean knows(int a, int b) {
        return false;
    }
}
