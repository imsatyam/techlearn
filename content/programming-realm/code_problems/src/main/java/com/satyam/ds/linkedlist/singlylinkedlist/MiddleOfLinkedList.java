package com.satyam.ds.linkedlist.singlylinkedlist;

import com.satyam.ds.linkedlist.SLLNode;

/**
    Concept of fast pointer and slow pointer

    Time complexity: O(n)
 */

public class MiddleOfLinkedList {

    private static SLLNode<Integer> getMiddleNode(SLLNode<Integer> node) {

        if (node == null) {
            return null;
        }

        SLLNode<Integer> fast = node;
        SLLNode<Integer> slow = node;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {

        SLLNode<Integer> node = new SLLNode<>(1);
        node.setNext(new SLLNode<>(2));
        node.getNext().setNext(new SLLNode<>(3));
        node.getNext().getNext().setNext(new SLLNode<>(4));
        node.getNext().getNext().getNext().setNext(new SLLNode<>(5));

        SLLNode<Integer> middleNode = getMiddleNode(node);

        System.out.println("Middle node is: " + middleNode.getValue());
    }

}
