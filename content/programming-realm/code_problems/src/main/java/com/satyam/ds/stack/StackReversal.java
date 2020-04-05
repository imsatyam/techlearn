package com.satyam.ds.stack;

import java.util.ListIterator;
import java.util.Stack;

/**
    Sort a stack using recursion.
 */
public class StackReversal {

    private static void insertItem(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        int y = stack.pop();
        insertItem(stack, x);
        stack.push(y);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverseStack(stack);
            insertItem(stack, x);
        }
    }

    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println(" \n\nStack elements before reversal:");
        printStack(s);

        reverseStack(s);

        System.out.println(" \n\nStack elements after reversal:");
        printStack(s);

    }

    private static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while(lt.hasNext())
            lt.next();

        // printing from top to bottom
        while(lt.hasPrevious())
            System.out.print(lt.previous()+" ");
    }
}
