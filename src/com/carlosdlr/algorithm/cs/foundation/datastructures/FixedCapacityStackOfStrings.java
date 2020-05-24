package com.carlosdlr.algorithm.cs.foundation.datastructures;

/**
 * Stack implementation using an array with a fixed capacity provided by the clients
 */
public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item; // use to index unto array then increment N
    }

    public String pop() {
        String item = s[--N];
        s[N] = null; // to remove the reference and allows to garbage collector reclaim memory
        return item; // decrement N then use to index into array
    }
}
