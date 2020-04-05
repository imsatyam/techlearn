package com.satyam.problem.leetcode.easy;

/**

 LC #157
 The API: int read4(char *buf) reads 4 characters at a time from a file.
 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 Note: The read function will only be called once for each test case.

 Idea:
 Read and copy using System.arraycopy()

 Submission Detail
    - NA -

 Reference:
    https://www.youtube.com/watch?v=dz2vDJubvhI

 */

public class LC157ReadNCharGivenRead4 extends Reader4 {

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i+=4) {
            char[] temp = new char[4];
            int len = read4(temp);
            System.arraycopy(temp, 0, buf, i, Math.min(len, n - i));
            if(len < 4) {
                return Math.min(i + len, n);
            }
        }
        return n;
    }

}

// GIVEN by leetcode
class Reader4 {
    int read4(char[] arr) {
        return -1;
    }
}
