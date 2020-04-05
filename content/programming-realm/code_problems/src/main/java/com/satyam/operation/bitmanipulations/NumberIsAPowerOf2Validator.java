package com.satyam.operation.bitmanipulations;


/**

 There are multiple approaches:

 1. Use log.
    Value of n log 2 must be an integer. We can use following formula to ascertain this:
        Math.ceil(Math.log(n) / Math.log(2))  ==  Math.floor(Math.log(n) / Math.log(2))


 2. All powers of 2 has only one bit set. Hence we can use the set bit count approach
    Integer.bitCount(n) == 2

 3. If we subtract a power of 2 numbers by 1 then all unset bits after the only set bit become set; and the set bit become unset.
    So, if a number n is a power of 2 then bitwise & of n and n-1 will be zero.
    We can say n is a power of 2 or not based on value of n&(n-1).
    The expression n&(n-1) will not work when n is 0. We should handle it separately

 */
public class NumberIsAPowerOf2Validator {

    private static boolean isPowerOfTwoUsingLogApproach(int n) {
        if (n == 0) {
            return false;
        }
        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }

    private static boolean isPowerOfTwoUsingBitCountApproach(int n) {
        return Integer.bitCount(n) == 1;
    }

    private static boolean isPowerOfTwoUsingBitwiseAndApproach(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 4;

        System.out.println(n + " is divisible by 2 using logarithmic approach: " + isPowerOfTwoUsingLogApproach(n));
        System.out.println(n + " is divisible by 2 using bit count approach: " + isPowerOfTwoUsingBitCountApproach(n));
        System.out.println(n + " is divisible by 2 using bitwise and approach: " + isPowerOfTwoUsingBitwiseAndApproach(n));

    }
}
