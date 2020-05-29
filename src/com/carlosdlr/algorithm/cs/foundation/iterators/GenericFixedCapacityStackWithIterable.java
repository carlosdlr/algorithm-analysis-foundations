package com.carlosdlr.algorithm.cs.foundation.iterators;

import java.util.Iterator;

/**
 * fixed capacity array stack using generic type
 * @param <Item>
 */
public class GenericFixedCapacityStackWithIterable<Item> implements Iterable<Item>{
    private Item[] s;
    private int N = 0;

    public GenericFixedCapacityStackWithIterable(int capacity) {
        s = (Item []) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item; // use to index unto array then increment N
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null; // to remove the reference and allows to garbage collector reclaim memory
        return item; // decrement N then use to index into array
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
