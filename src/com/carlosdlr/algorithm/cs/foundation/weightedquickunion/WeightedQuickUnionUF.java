package com.carlosdlr.algorithm.cs.foundation.weightedquickunion;

/**
 * weighted quick union strategy implementation for graphs data structures
 * cost for initialize N, for union log N and for is connected operation log N
 */
public class WeightedQuickUnionUF {
    private final int [] id;
    private final int [] sz; // this array will contain the number of objects in the tree rooted at i.

    /**
     * initialize quick-union data structure with N objects
     * @param N number of objects
     */
    public WeightedQuickUnionUF(int N) {
        this.id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i ++)
            id[i] = i;
    }

    /**
     * chase parent pointer until reach root
     * improvement adding path compression, is just make every visited node point to his parent with this we make
     * the trees flat as possible
     * @param i array value to search
     * @return the root position in the array
     */
    private int getRoot(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // we make here to the node id[i] to point to his parent
            i = id[i];
        }
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
     * change the root of p to root of q.
     * in the weighted quick union we link the smaller tree to the larger tree
     * after update the sz array with the new weight or number of objects for the tree
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);

        if(i == j) // p and q has the same root so nothing to do
            return;

        if(sz[i] < sz[j]) { //we check here if the size of the tree p is less than q tree
            id[i] = j; // we assign the root tree of q to the value of p tree
            sz[j] += sz[i]; // we update the new size of the tree q with the size of p tree
        }else {
            id[j] = i; // we assign the root tree of p to the value of q tree
            sz[i] += sz[j]; // we update the new size of the tree p with the size of q tree
        }
    }
}
