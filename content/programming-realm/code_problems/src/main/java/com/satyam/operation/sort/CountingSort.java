package com.satyam.operation.sort;

import com.satyam.common.ArrayUtils;

/**

 Counting sort assumes that the input elements are n integers in the range [0, k]. When k = O(n), then the counting sort
 will run in O(n) time.

 Example:
 consider the data in the range 0 to 9.
 Input data: 1, 4, 1, 2, 7, 5, 2
 1) Take a count array to store the count of each unique object.
 Index:     0  1  2  3  4  5  6  7  8  9
 Count:     0  2  2  0   1  1  0  1  0  0

 2) Modify the count array such that each element at each index
 stores the sum of previous counts.
 Index:     0  1  2  3  4  5  6  7  8  9
 Count:     0  2  4  4  5  6  6  7  7  7

 The modified count array indicates the position of each object in
 the output sequence.

 3) Output each object from the input sequence followed by
 decreasing its count by 1.
 Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
 Put data 1 at index 2 in output. Decrease count by 1 to place
 next data 1 at an index 1 smaller than this index.

 Complexity:
 It computes the C array in O(n+k) time: It once iterates an input array with size n in O(n) and then iterates the C in O(k)
 – so that would be O(n+k) in total

 After computing the C, it sorts the input by iterating the input array and performing a few primitive operations in each
 iteration. So, the actual sort operation takes O(n)

 In total, counting sort takes O(n+k) time to run

 */
public class CountingSort {

    private static void doCountingSort(int[] arr, int n) {

        int[] result = new int[n + 1];
        int[] count = new int[n + 1];

        for (int a : arr) {
            count[a]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {          // process in reverse order to make it stable

            result[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i<n; ++i) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {10, 10, 8, 7, 6, 5, 4, 3, 2, 1};
        doCountingSort(arr, arr.length);
        ArrayUtils.print(arr, " ");
    }
}
