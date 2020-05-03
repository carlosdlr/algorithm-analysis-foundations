package com.carlosdlr.algorithm.cs.foundation.quickunion;

/**
 * quick union strategy implementation for graphs data structures
 * cost of initialize N, for make union between to nodes N needs to check for the root of the node,
 * for connected operation N needs to check for the root of the node,
 */
public class QuickUnionUF {
    private final int [] id;

    /**
     * initialize quick-union data structure with N objects
     * @param N number of objects
     */
    public QuickUnionUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i ++)
            id[i] = i;
    }

    /**
     * chase parent pointer until reach root
     * @param i array value to search
     * @return the root position in the array
     */
    private int getRoot(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    /**
     * check if p and q have the same root
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /**
     * change the root of p to root of q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        id[i] = j;
    }
}
