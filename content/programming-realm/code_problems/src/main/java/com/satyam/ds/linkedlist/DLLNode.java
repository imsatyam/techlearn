package com.satyam.ds.linkedlist;

/**
 * Represents node of a Doubly linked list
 */
public class DLLNode<T> {

    private T value;
    private DLLNode<T> next;
    private DLLNode<T> prev;

    public DLLNode() {
    }

    public DLLNode(T value) {
        this.value = value;
    }

    public DLLNode(T value, DLLNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public DLLNode(T value, DLLNode<T> next, DLLNode<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DLLNode<T> getNext() {
        return next;
    }

    public void setNext(DLLNode<T> next) {
        this.next = next;
    }

    public DLLNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DLLNode<T> prev) {
        this.prev = prev;
    }
}
