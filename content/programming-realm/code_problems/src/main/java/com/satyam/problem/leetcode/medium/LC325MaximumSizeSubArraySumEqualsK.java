package com.satyam.problem.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**

 LC #325
 Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?

 Idea:
 The idea of the problem is to check where there is a range from i to j, inclusive, so that its sum equals to k,
 nd the length of the range is the maximum.

 So we can naturally think of this question as a range summary problem, and we need to calculate
 the prefix sum of the array first. So the sum(i, j) = presum[j] - presum[i - 1] = k

 Submission Detail
    - NA -

 */

public class LC325MaximumSizeSubArraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int max = -1;
        hm.put(0,0);
        for(int i = 1; i < nums.length + 1; i++){
            sum += nums[i-1];
            int target = sum - k;
            if(hm.containsKey(target)){
                max = Math.max(max, i - hm.get(target));
            }

            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }
        }
        if(max == -1){
            return 0;
        }else{
            return max;
        }
    }

}
