package com.satyam.problem.leetcode.medium;

/**

 LC #276
 There is a fence with n posts, each post can be painted with one of the k colors.
 You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 Return the total number of ways you can paint the fence.

 Note: n and k are non-negative integers.

 Idea:
    If n == 1, there would be k-ways to paint.

    if n == 2, there would be two situations:
     a. You paint same color with the previous post: k*1 ways to paint, named it as same;
     b. You paint differently with the previous post: k*(k-1) ways to paint this way, named it as diff.

    So, you can think, if n >= 3, you can always maintain these two situations, You either paint the same color
    with the previous one, or differently. Since there is a rule: “no more than two adjacent fence posts have the same color.”

 if the first one and the second one has the same color, then the third one has k-1 options. The first and second together has k options.
 If the first and the second do not have same color, the total is k * (k-1), then the third one has k options.
 Therefore, f(3) = (k-1)*k + k*(k-1)*k
                 = (k-1)(k+k*k)

 Submission Detail
    - NA -

 Reference(s)
    https://www.youtube.com/watch?v=deh7UpSRaEY
    https://www.programcreek.com/2014/05/leetcode-pain-fence-java/

 */

public class LC276PaintFence {

    public int numWays(int n, int k) {
        int dp[] = {0, k , k*k, 0};

        if(n <= 2)
            return dp[n];

        for(int i = 2; i < n; i++){
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }

}
