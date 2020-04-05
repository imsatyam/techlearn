package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem.
 Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range.
 How do we sort the numbers efficiently?

 bucketSort(arr[], n)
 1) Create n empty buckets (Or lists).
 2) Do following for every array element arr[i].
 .......a) Insert arr[i] into bucket[n*array[i]]
 3) Sort individual buckets using insertion sort.
 4) Concatenate all sorted buckets.

 Complexity:
 If one assumes that insertion in a bucket takes  time, then steps 1 and 2 of the above algorithm clearly take  time.

 Worst case scenario: all of our elements in the same bucket and in reverse order. O(n^2)

 */
public class BucketSort {

    private static void doBucketSort(int[] arr, int n) {

        int numberOfBuckets = n + 1;
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);

        int i = 0;
        while (i < numberOfBuckets) {
            buckets.add(new ArrayList<>());
            i++;
        }

        for (i = 0; i < n; i++) {
            int bucketIndex = arr[i] / n;
            buckets.get(bucketIndex).add(arr[i]);
        }

        for (i = 0; i < numberOfBuckets; i++) {
            List<Integer> bucket = buckets.get(i);
            if (!bucket.isEmpty()) {
                Collections.sort(bucket);
            }
        }

        int j = 0;
        for (i = 0; i < numberOfBuckets; i++) {
            List<Integer> bucket = buckets.get(i);
            if (!bucket.isEmpty()) {
                for (int item : bucket) {
                    arr[j++] = item;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        doBucketSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }

}
