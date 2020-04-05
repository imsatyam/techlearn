package com.satyam.problem.leetcode.medium;

import java.util.Iterator;

/**

 LC #284
 Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that
 support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Idea:
    Use variable peek in addition to iterator

 Submission Detail
    Link: https://leetcode.com/submissions/detail/286706240/
    Runtime: 45 ms
    Memory: 35.6 MB

 */

public class LC284PeekingIteraror implements Iterator<Integer> {

    private Integer peek;
    private Iterator<Integer> iterator;

    public LC284PeekingIteraror(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.peek = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek != null) {
            return peek;
        }

        if (iterator.hasNext()) {
            peek = iterator.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer returnValue = null;
        if (peek != null) {
            returnValue = peek;
            peek = null;
        } else if (iterator.hasNext()) {
            returnValue = iterator.next();
        }
        return returnValue;
    }

    @Override
    public boolean hasNext() {
        return (peek != null) || iterator.hasNext();
    }

}
