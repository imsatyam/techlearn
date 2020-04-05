package com.satyam.problem.miscellaneous;

/**

 Count pairs a, b whose sum of cubes is N i.e. a^3 + b^3 = N

 */

public class PairsWithSumOfCubesEqualToN {

    private static int getPairsWithSumOfCubesEqualToN(int n) {

        int count = 0;
        int cubeRootOfN = (int) Math.cbrt(n);

        for (int i = 1; i <= cubeRootOfN; i++) {
            int cb = i*i*i;
            int diff = n - cb;
            int cbrtOfDiff = (int) Math.cbrt(diff);
            if (cbrtOfDiff * cbrtOfDiff * cbrtOfDiff == diff) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        int pairCount = getPairsWithSumOfCubesEqualToN(n);
        System.out.println("N = " + n + ", Number of pairs: " + pairCount);
    }

}
