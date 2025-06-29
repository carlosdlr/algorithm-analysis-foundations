package com.carlosdlr.algorithm.cs.foundation.datastructures;

import edu.princeton.cs.algs4.*;

public class Graph {

    private final int V; // number of vertices
    private Bag<Integer>[] adj; // adjacency list

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // add w to v's list
        adj[w].add(v); // add v to w's list
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
