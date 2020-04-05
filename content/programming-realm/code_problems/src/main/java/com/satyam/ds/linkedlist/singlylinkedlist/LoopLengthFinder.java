package com.satyam.ds.linkedlist.singlylinkedlist;

import com.satyam.ds.linkedlist.SLLNode;

import java.util.Objects;

/**

 Floyed cycle detection algorithm
    fast and slow pointer meet at a common point.

 From the common point, keep visiting next until the common point is reached again. Keep track of the count.

 */

public class LoopLengthFinder {

    private static int findLengthOfTheLoop(SLLNode<Integer> node) {
        SLLNode<Integer> cyclicNode = getCommonNodeForCycle(node);
        if (null == cyclicNode) {
            return 0;
        }

        int count = 1;
        SLLNode<Integer> temp = cyclicNode.getNext();
        while (temp != null && temp != cyclicNode) {
            temp = temp.getNext();
            count++;
        }

        return Objects.isNull(temp) ? 0 : count;
    }

    private static SLLNode<Integer> getCommonNodeForCycle(SLLNode<Integer> node) {
        if (node == null) {
            return null;
        }

        SLLNode<Integer> fast = node;
        SLLNode<Integer> slow = node;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        SLLNode<Integer> node = new SLLNode<>(1);
        node.setNext(new SLLNode<>(2));

        SLLNode<Integer> thirdNode = new SLLNode<>(3);

        node.getNext().setNext(thirdNode);
        node.getNext().getNext().setNext(new SLLNode<>(4));
        node.getNext().getNext().getNext().setNext(new SLLNode<>(5));
        node.getNext().getNext().getNext().getNext().setNext(thirdNode);

        int loopLength = findLengthOfTheLoop(node);
        System.out.println("Length of the loop: " + loopLength);
    }

}
