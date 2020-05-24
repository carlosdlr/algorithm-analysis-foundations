package com.carlosdlr.algorithm.cs.foundation.datastructures;

/**
 * Queue implementation using linked list
 */
public class LinkedQueueOfStrings {

    private Node first, last; // keep track of the first and last element

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) { // special case when the queue is empty
            first = last;
        }
        else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }
}
