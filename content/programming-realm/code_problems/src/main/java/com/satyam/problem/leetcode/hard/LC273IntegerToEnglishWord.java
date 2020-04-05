package com.satyam.problem.leetcode.hard;

/**

 LC #273
 Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

 Example 1:

 Input: 123
 Output: "One Hundred Twenty Three"
 Example 2:

 Input: 12345
 Output: "Twelve Thousand Three Hundred Forty Five"
 Example 3:

 Input: 1234567
 Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 Example 4:

 Input: 1234567891
 Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

 Idea:
     Use predefined lists to convert to english

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291745889/
    Runtime: 2 ms
    Memory: 36 MB

 Reference
    https://leetcode.com/problems/integer-to-english-words/discuss/414020/Java-100-100

 */

public class LC273IntegerToEnglishWord {

    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final String[] WORDS = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private static final String[] TENS = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] TEENS = {"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

    public String numberToWords(int num) {
        if(num==0) return "Zero";

        StringBuilder sb = new StringBuilder();

        int slice = getBillions(num);
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Billion ");

        slice = getMillions(num);
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Million ");

        slice = getThousands(num);
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice) + "Thousand ");

        slice = getSubThousand(num);
        if(slice>0) sb.append(getWordsForPositiveThreeDigit(slice));

        return sb.toString().trim();
    }

    private int getBillions(int num) {
        return num / BILLION;
    }

    private int getMillions(int num) {
        return num % BILLION / MILLION;
    }

    private int getThousands(int num) {
        return num % MILLION / THOUSAND;
    }

    private int getSubThousand(int num) {
        return num % THOUSAND;
    }

    private String getWordsForPositiveThreeDigit(int num) {
        if(num>THOUSAND || num==0) return null;

        StringBuilder sb = new StringBuilder();

        int hundreds = num/HUNDRED;
        if(hundreds>0) sb.append(getWordForPositiveSingleDigit(hundreds) + "Hundred ");

        int tens = num % HUNDRED / TEN;
        int ones = num % TEN;
        if(tens == 1 && ones>0) {
            sb.append(TEENS[ones-1]);
        } else {
            if(tens>0) sb.append(TENS[tens-1]);
            if(ones>0) sb.append(getWordForPositiveSingleDigit(ones));
        }

        return sb.toString();
    }

    private String getWordForPositiveSingleDigit(int num) {
        if(num>TEN || num==0) return null;
        return WORDS[num-1];
    }

}
