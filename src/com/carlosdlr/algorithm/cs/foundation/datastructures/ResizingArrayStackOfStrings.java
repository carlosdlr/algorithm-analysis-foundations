package com.carlosdlr.algorithm.cs.foundation.datastructures;

import java.util.Arrays;

/**
 * Stack implementation using an array with resize strategy (resize the array twice the size and copy the items)
 * shrink in the pop operation to avoid waste space checking when the array is 25% (1/4) of capacity and after
 * resize the array to halve.
 */
public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        // resize the array twice the size and copy the items
        if(N == s.length) resize(2 * s.length);
        s[N++] = item; // use to index unto array then increment N
    }

    public String pop() {
        String item = s[--N];
        s[N] = null; // to remove the reference and allows to garbage collector reclaim memory
        //checking when the array is 25% (1/4) of capacity and after resize the array to halve.
        if (N > 0  && N == s.length/4) resize(s.length/2);
        return item; // decrement N then use to index into array
    }

    private void resize(int capacity) {
        String [] copy = Arrays.copyOf(s, capacity);
        s = copy;
    }
}
