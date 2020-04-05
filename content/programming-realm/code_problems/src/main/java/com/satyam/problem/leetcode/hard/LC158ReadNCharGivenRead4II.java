package com.satyam.problem.leetcode.hard;

/**

 LC #158
 The API: int read4(char *buf) reads 4 characters at a time from a file.
 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.

 Idea:
 Use two pointers one from beginning and another from end.

 Submission Detail
    - NA -

 */

public class LC158ReadNCharGivenRead4II extends Reader4 {

    private char[] buf4 = new char[4];
    private int buf4Index = 4;
    private int buf4Size = 4;
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (buf4Index >= buf4Size) {
                buf4Size = read4(buf4);
                buf4Index = 0;
                if (buf4Size == 0) {
                    break;
                }
            }
            buf[i] = buf4[buf4Index];
            buf4Index++;
            i++;
        }
        return i;
    }
}

// GIVEN by leetcode
class Reader4 {
    int read4(char[] arr) {
        return -1;
    }
}
