package com.satyam.problem.leetcode.medium;

/**

 LC #31
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 1,2,3 → 1,3,2
 3,2,1 → 1,2,3

 Idea:
    Narayana Pandita’s algorithm
    1) scan from right to left, find the first element that is less than its previous one.
    2) scan from right to left, find the first element that is greater than p.
    3) swap p and q
    4) reverse elements [p+1, nums.length]

 Submission Detail
    Link: https://leetcode.com/submissions/detail/308653359/
    Runtime: 0 ms
    Memory: 39   MB

 */

public class LC31NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }

        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index+1]) {
            index--;
        }

        if (index >= 0) {

            // find rightmost element greater than the one at index
            int k = nums.length - 1;
            while (k > 0 && nums[k] <= nums[index]) {
                k--;
            }
            swap(nums, index, k);
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] arr, int startIndex) {
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            swap(arr, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }


    private void swap(int[] arr, int to, int from) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

}
