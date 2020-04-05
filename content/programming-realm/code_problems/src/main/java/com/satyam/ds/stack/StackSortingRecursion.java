package com.satyam.ds.stack;

import java.util.ListIterator;
import java.util.Stack;

/**
    Sort a stack using recursion.
 */
public class StackSortingRecursion {

    private static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack, x);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int x) {

        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack, x);
        stack.push(temp);
    }

    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(" \n\nStack elements after sorting:");
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
