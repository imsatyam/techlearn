package com.satyam.problem.leetcode.medium;

/**

 LC #211
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .
 A . means it can represent any one letter.

 Example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 Idea:
     Use trie.
     addWord: iterate through the word. Start from the root trie node. If current character does not map to a trie node,
        create a new one and map them. Otherwise, go to the next trie node.
     Search: iterate through the word. If current character is '.', then iterate through the entire map and recursively
            search for the remaining string. Otherwise, move current trie node to the child and check if the last node is word.

 Submission Detail
    Link: https://leetcode.com/submissions/detail/291744886/
    Runtime: 33 ms
    Memory: 56 MB

 */

public class LC211AddAndSearchWord {

    private TrieNode root;

    /** Initialize your data structure here. */
    public LC211AddAndSearchWord() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null) {
            return;
        }

        TrieNode current = this.root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && search(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children[c - 'a'];
            if (child == null) {
                return false;
            }
            return search(word, index + 1, child);
        }
    }

    static class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

}
