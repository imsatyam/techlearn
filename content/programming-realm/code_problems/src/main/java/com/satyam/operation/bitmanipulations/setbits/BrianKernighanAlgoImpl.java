package com.satyam.operation.bitmanipulations.setbits;

/**

 Trivia:
 Subtracting 1 from a decimal number flips all the bits after the rightmost set bit(which is 1) including the rightmost bit.

 Therefore n & n-1 would remove the rightmost set bit from n.

 Time complexity: O(log n)

 */

public class BrianKernighanAlgoImpl {

    private  static int getCountOfSetBits(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("Number of set bits in " + n + ": " + getCountOfSetBits(n));
    }
}
