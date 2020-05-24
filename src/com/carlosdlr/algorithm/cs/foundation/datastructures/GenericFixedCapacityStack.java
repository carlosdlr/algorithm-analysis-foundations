package com.carlosdlr.algorithm.cs.foundation.datastructures;

/**
 * fixed capacity array stack using generic type
 * @param <Item>
 */
public class GenericFixedCapacityStack<Item> {
    private Item[] s;
    private int N = 0;

    public GenericFixedCapacityStack(int capacity) {
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
}
