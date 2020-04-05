package com.satyam.operation.conversion;

/**

    Binary:     1 1 0 1 0
                    <----
    Decimal:    2^4 * 1  + 2^3 * 1  + 2^2 * 0  + 2^1 * 1  + 2^0 * 0

 */

public class BinaryToDecimalConverter {

    private static int toDecimal(long binaryRepresentation) {
        int base = 1; // 2^0
        int decimalValue = 0;
        long temp = binaryRepresentation;

        while (temp > 0) {
            int lastDigit = (int) (temp % 10);
            temp = temp / 10;
            decimalValue += lastDigit * base;
            base = base * 2;
        }

        return decimalValue;
    }

    public static void main(String[] args) {
        long binaryRep = 11010;
        int decimalValue = toDecimal(binaryRep);
        System.out.println("Binary: " + binaryRep + "  Decimal: " + decimalValue);
    }


}
