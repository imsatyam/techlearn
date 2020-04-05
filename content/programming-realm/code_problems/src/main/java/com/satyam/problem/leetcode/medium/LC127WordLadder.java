package com.satyam.problem.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**

 LC #127
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
  - Only one letter can be changed at a time.
  - Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 Note:
  - Return 0 if there is no such transformation sequence.
  - All words have the same length.
  - All words contain only lowercase alphabetic characters.
  - You may assume no duplicates in the word list.
  - You may assume beginWord and endWord are non-empty and are not the same.

 Idea:
    Use level order traversal. Sort of similar to rotten oranges problem

 Submission Detail
    Link: https://leetcode.com/submissions/detail/279508954/
    Runtime: 46 ms
    Memory: 49.1 MB

 */

public class LC127WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        int transformations = 0;
        q.offer(beginWord);

        while (!q.isEmpty()) {

            // process one level at a time
            for (int k = q.size(); k > 0; k--) {

                String word = q.poll();
                if (endWord.equals(word)) {
                    return transformations + 1;
                }

                for (int i = 0; i < word.length(); i++) {
                    char[] wordChars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordChars[i] = ch;
                        String transformedWord = new String(wordChars);
                        if (wordSet.contains(transformedWord)) {
                            q.offer(transformedWord);
                            wordSet.remove(transformedWord);
                        }
                    }
                }
            }

            transformations++;
        }
        return 0;
    }

}
