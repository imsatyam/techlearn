package com.satyam.operation.bitmanipulations.setbits;

/**

 Lookup table approach:

    Size of integer = 32 bits
    we break 32 bits into chunk of 8 bits.
    create a lookup table of 2^8 - 1 size
    store number of set bits in the table: lookupTable[0] = 0, lookupTable[1] = 1, lookupTable[2] = 2
        here value is the number of set bits in that number.

    Whenever a number is given i.e. 354, convert it into 32 bit binary with each chunk of 8 bits
    354 = 00000000 00000000 00000001 01100010
            |          |        |       |
            0          0        1       98

     setBitCount(354)   = setBitCount(0) + setBitCount(0) + setBitCount(1) + setBitCount(98)
                        = lookupTable[0] + lookupTable[0] + lookupTable[1] + lookupTable[98]
                        = 0 + 0 + 1 + 3
                        = 4

    In java, this can simply work with Integer.bitCount(n) method call.

    Complexity: O(1)

 */

public class LookupTableBasedSetBitCount {

    private static int getCountOfSetBits(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("Number of set bits in " + n + ": " + getCountOfSetBits(n));
    }

}
