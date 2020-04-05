package com.satyam.problem.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**

 LC #71
 Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

 In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

 Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 Example 1:
 Input: "/home/"
 Output: "/home"
 Explanation: Note that there is no trailing slash after the last directory name.

 Example 2:
 Input: "/../"
 Output: "/"
 Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

 Example 3:
 Input: "/home//foo/"
 Output: "/home/foo"
 Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

 Idea:
    1. split the path by "/", to get String array with "directory name", ".", "..", also some blank
    2. loop through the array.
        if folder name - push to deque
        if . do nothing as it is current directory
        if .. remove last from deque as it .. for one folder back.
    3. At the end of array, stack would have appropriate path. Construct path.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291727842/
    Runtime: 4 ms
    Memory: 36.6 MB

 */

public class LC71SimplifyPath {

    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return "";
        }

        Deque<String> queue = new LinkedList<>();

        for (String p : path.split("/")) {

            p = p.trim();

            if (p.isEmpty() || p.equals(".")) {
                continue;
            }

            if (p.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
                continue;
            }

            queue.offer(p);
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append("/").append(queue.poll());
        }
        String resolvedPath = builder.toString();

        return resolvedPath.isEmpty() ? "/" : resolvedPath;
    }

}
