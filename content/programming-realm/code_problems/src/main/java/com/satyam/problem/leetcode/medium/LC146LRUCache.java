package com.satyam.problem.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**

 LC #146
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 Idea:
    Use hashmap and doubly linked list

 Submission Detail
    Link: https://leetcode.com/submissions/detail/287149343/
    Runtime: 15 ms
    Memory: 50.2 MB

 */

public class LC146LRUCache {

    private int capacity;
    private int count;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LC146LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.prev = null;
        this.tail.next = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node valueNode = map.get(key);
            touchNode(valueNode);
            return valueNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            Node valueNode = map.get(key);
            valueNode.val = value;
            touchNode(valueNode);

        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count >= capacity) {
                removeEldestEntry();
            }

            this.count++;
            addFrontEntry(node);
        }
    }

    private void touchNode(Node node) {
        deleteNode(node);
        addFrontEntry(node);
    }

    private void removeEldestEntry() {
        map.remove(this.tail.prev.key);
        deleteNode(tail.prev);
        this.count--;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFrontEntry(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
