package com.satyam.problem.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

/**

 Input: {54, 546, 548, 60}
 Output: 60 548 546 54

 Idea: Sort the array using String comparison.

 */

public class BiggestNumberFromGivenNumbers {

    private static long getLargestNumber(Integer[] arr) {

        Comparator<Integer> comparator = (a, b)-> {
           String strA = String.valueOf(a);
           String strB = String.valueOf(b);
           return (strB + strA).compareTo(strA + strB);
        } ;
        Arrays.sort(arr, comparator);
        StringBuilder builder = new StringBuilder();
        for (int x : arr) {
            builder.append(x);
        }
        return Long.parseLong(builder.toString());
    }

    public static void main(String[] args) {
        Integer[] arr = {54, 546, 548, 60};
        System.out.println(getLargestNumber(arr));
    }

}
