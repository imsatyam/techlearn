package com.satyam.algorithm.backtracking;

/**

 Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of
 two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2
 and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.


 For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10.
 Output for this set should be {4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}.
 Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).


 Let us consider another example where n is odd.Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}.
 The output subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}.
 The sums of elements in two subsets are 120 and 121 respectively.

 IDEA:
 There are two possibilities for every element, either it is part of current set, or it is part of the remaining elements (other subset).
 We consider both possibilities for every element. When the size of current set becomes n/2, we check whether this
 solution is better than the best solution available so far. If it is, then we update the best solution.

 */

public class TugOfWar {

    // Used to keep track of minimum difference
    static class Difference {
        private int diff = Integer.MAX_VALUE;
    }


    private static void solveTugOfWar(int[] arr) {

        int totalElements = arr.length;
        boolean[] currentElements = new boolean[totalElements];     // <- keeps track of elements considered "so far"
        boolean[] sol = new boolean[totalElements];                 // <- eventual solution
        Difference minDiff = new Difference();
        int sum = 0;
        for (int i = 0; i < totalElements; i++) {
            sum += arr[i];
            currentElements[i] = false;
            sol[i] = false;
        }

        solveTugOfWar(arr, totalElements, sol, currentElements, sum, minDiff, 0, 0, 0);
        printSolution(arr, totalElements, sol);
    }


    private static void solveTugOfWar(int[] arr, int totalElements, boolean[] sol, boolean[] currentElements, int sum, Difference minDiff,
                               int selectedElementCount, int currentSum, int currentPosition) {

        if (currentPosition == totalElements) {
            return;
        }

        // checks that the numbers of elements left are not less than the number of elements
        // required to form the solution
        if ((totalElements / 2 - selectedElementCount) > totalElements - currentPosition) {
            return;
        }

        // current element is not considered in solution.
        solveTugOfWar(arr, totalElements, sol, currentElements, sum, minDiff, selectedElementCount, currentSum, currentPosition + 1);

        selectedElementCount++;
        currentSum += arr[currentPosition];
        currentElements[currentPosition] = true;
        if (selectedElementCount == totalElements / 2) {
            int differenceOfSum = Math.abs((sum/2) - currentSum);
            if (differenceOfSum < minDiff.diff) {
                minDiff.diff = differenceOfSum;
                for (int i = 0; i < totalElements; i++) {
                    sol[i] = currentElements[i];
                }
            }
        } else {
            solveTugOfWar(arr, totalElements, sol, currentElements, sum, minDiff, selectedElementCount, currentSum, currentPosition + 1);
        }
        currentElements[currentPosition] = false;
    }


    public static void main(String[] args) {
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        solveTugOfWar(arr);
    }


    private static void printSolution(int[] arr, int n, boolean[] soln) {
        System.out.print("The first subset is: ");
        for (int i = 0; i < n; i++)
        {
            if (soln[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.print("\nThe second subset is: ");
        for (int i = 0; i < n; i++)
        {
            if (soln[i] == false)
                System.out.print(arr[i] + " ");
        }
    }

}
