package com.be1ive.hackerrank.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/even-tree
 */
public class EvenTree {

    public static class Graph {
        private Map<Integer, Set<Integer>> graph = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();
        private int forest = 0;

        private void addEdge(Integer v, Integer u) {
            Set<Integer> adj = graph.get(v);
            if (adj == null) {
                adj = new HashSet<>();
                graph.put(v, adj);
            }
            adj.add(u);
        }

        private int visit(Integer v) {
            visited.add(v);
            int count = 1;
            for (Integer u : graph.get(v)) {
                if (!visited.contains(u)) {
                    int tmp = visit(u);
                    if (tmp % 2 != 0 || tmp == 0) {
                        count += tmp;
                    } else {
                        forest++;
                    }
                }
            }
            return count;
        }

        public void dfs() {
            for (Integer v : graph.keySet()) {
                if (!visited.contains(v)) {
                    visit(v);
                }
            }
        }

        public int forests() {
            return forest;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] params = reader.readLine().split(" ");
        int N = Integer.parseInt(params[0]);
        int M = Integer.parseInt(params[1]);

        Graph g = new Graph();
        for (int i = 0; i < M; i++) {
            String[] edge = reader.readLine().split(" ");
            int v = Integer.parseInt(edge[0]);
            int u = Integer.parseInt(edge[1]);
            g.addEdge(v, u);
            g.addEdge(u, v);
        }
        g.dfs();
        writer.println(g.forests());
        writer.flush();
        writer.close();
    }
}
