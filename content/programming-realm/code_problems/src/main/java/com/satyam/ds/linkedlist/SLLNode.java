package com.satyam.ds.linkedlist;

/**
 * Represents node of a singly linked list
 */
public class SLLNode<T> {

    private T value;
    private SLLNode<T> next;

    public SLLNode() {
    }

    public SLLNode(T value) {
        this.value = value;
    }

    public SLLNode(T value, SLLNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SLLNode<T> getNext() {
        return next;
    }

    public void setNext(SLLNode<T> next) {
        this.next = next;
    }
}
