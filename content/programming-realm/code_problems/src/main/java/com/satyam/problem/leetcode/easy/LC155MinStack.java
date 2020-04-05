package com.satyam.problem.leetcode.easy;

import java.util.Stack;

/**

 LC #155
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Idea:
 Store a composite entry in stack i.e. val  and minSoFar

 Submission Detail
    Link: https://leetcode.com/submissions/detail/277220629/
    Runtime: 5 ms
    Memory: 38.8 MB

 */

public class LC155MinStack {

    private Stack<Entry> stack;

    /** initialize your data structure here. */
    public LC155MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int minValue = x;
        if (!stack.isEmpty()) {
            minValue = Math.min(x, stack.peek().minSoFar);
        }
        stack.push(new Entry(x, minValue));
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().value;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().minSoFar;
    }


    static class Entry {
        private int value;
        private int minSoFar;
        public Entry(int value, int minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }
    }

}
