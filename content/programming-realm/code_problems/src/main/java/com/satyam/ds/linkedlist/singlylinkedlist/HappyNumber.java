package com.satyam.ds.linkedlist.singlylinkedlist;

/**

 A number is called happy if it leads to 1 after a sequence of steps where in each step number is replaced by sum of
 squares of its digit that is if we start with Happy Number and keep replacing it with digits square sum, we reach 1.

 Input: n = 19
 Output: True

 19 is Happy Number,
 1^2 + 9^2 = 82
 8^2 + 2^2 = 68
 6^2 + 8^2 = 100
 1^2 + 0^2 + 0^2 = 1
 As we reached to 1, 19 is a Happy Number.

 A number will not be a Happy Number when it makes a loop in its sequence that is it touches a number in sequence which
 already been touched. So to check whether a number is happy or not, we can keep a set, if same number occurs again we
 flag result as not happy.

 We can solve this problem without using extra space and that technique can be used in some other similar problem also.
 If we treat every number as a node and replacement by square sum digit as a link, then this problem is same as finding
 a loop in a linkedlist

 */

public class HappyNumber {

    private static boolean isHappyNumber(int n) {
        int fast = n, slow = n;
        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int getSquareSum(int n) {
        int squareSum = 0;
        while (n != 0) {
            int remainder = n % 10;
            squareSum = squareSum + (remainder * remainder);
            n /= 10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean isHappy = isHappyNumber(n);
        System.out.println("Q: Is " + n + " a happy number? \nA: " + isHappy);
    }
}
