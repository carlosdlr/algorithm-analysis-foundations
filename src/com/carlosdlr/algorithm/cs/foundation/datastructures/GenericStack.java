package com.carlosdlr.algorithm.cs.foundation.datastructures;

/**
 * A generic type implementation of a stack
 * @param <Item> object to be stored in the stack
 */
public class GenericStack<Item> {

    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
}
