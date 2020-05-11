package com.carlosdlr.algorithm.cs.foundation.quickfind;

/**
 * quick find strategy implementation for graphs data structures
 * cost of initialize N, for union N need to iterate over the entire array,
 * for is connected operation es 1 constant due to check if values are equals
 */
public class QuickFindUF {
    private final int[] id;

    /**
     * initialize quick-find data structure with N objects
     *
     * @param N number of objects
     */
    public QuickFindUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    /**
     * add connection between p and q
     * to merge this values replace all the id values in id[p] to id[q]
     *
     * @param p position in the array
     * @param q position in the array
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
    }

    /**
     * check if p and q are connected this if and only if
     * array value in position p and array value in position q are equals
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }


}
