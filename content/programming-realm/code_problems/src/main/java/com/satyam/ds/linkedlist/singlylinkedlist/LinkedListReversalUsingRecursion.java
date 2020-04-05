package com.satyam.ds.linkedlist.singlylinkedlist;

import com.satyam.ds.linkedlist.SLLNode;

public class LinkedListReversalUsingRecursion {

    private static SLLNode<Integer> reverseList(SLLNode<Integer> head) {
        if (head == null) {
            return null;
        }

        SLLNode<Integer> curr = head;
        SLLNode<Integer> next = head.getNext();
        curr.setNext(null);
        if (next == null) {
            return curr;
        }

        SLLNode<Integer> reverse = reverseList(next);
        next.setNext(curr);
        return reverse;
    }

    public static void main(String[] args) {

        SLLNode<Integer> node = new SLLNode<>(1);
        node.setNext(new SLLNode<>(2));
        node.getNext().setNext(new SLLNode<>(3));
        node.getNext().getNext().setNext(new SLLNode<>(4));
        node.getNext().getNext().getNext().setNext(new SLLNode<>(5));

        System.out.println("Before reversal: ");
        print(node);

        SLLNode<Integer> reversed = reverseList(node);

        System.out.println("After reversal: ");
        print(reversed);
    }

    private static void print(SLLNode<Integer> node) {
        SLLNode<Integer> curr = node;
        while (curr != null) {
            System.out.print(curr.getValue() + "\t");
            curr = curr.getNext();
        }
        System.out.println();
    }

}
