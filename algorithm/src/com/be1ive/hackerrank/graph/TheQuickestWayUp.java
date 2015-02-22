package com.be1ive.hackerrank.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */
public class TheQuickestWayUp {

    public static class Graph {
        private Map<Integer, Set<Integer>> graph = new HashMap<>();
        private Map<Integer, Integer> distance = new HashMap<>();

        public Graph(int size) {
            for (Integer i = 1; i <= size; i++) {
                graph.put(i, new HashSet<Integer>());
            }
        }

        public Set<Integer> adj(Integer v){
            return graph.get(v);
        }

        public void addEdge(Integer v, Integer u) {
            Set<Integer> adj = graph.get(v);
            if (adj == null) {
                adj = new HashSet<>();
                graph.put(v, adj);
            }
            adj.add(u);
        }

        public void bfs(Integer v) {
            Queue<Integer> queue = new ArrayDeque<Integer>();
            queue.offer(v);
            distance.put(v, 0);
            while(!queue.isEmpty()) {
                Integer u = queue.poll();
                Integer d = distance.get(u);
                for (Integer adj : graph.get(u)) {
                    if (distance.get(adj) == null) {
                        queue.offer(adj);
                        distance.put(adj, d + 1);
                    }
                }
            }
        }

        public Integer distance(Integer v) {
            return distance.get(v);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            Graph g = new Graph(100);

            String[] params = reader.readLine().split(",");
            int ladder = Integer.parseInt(params[0]);
            int snake = Integer.parseInt(params[1]);

            String[] ladders = reader.readLine().split(" ");
            for (int i = 0; i < ladder; i++) {
                String[] edge = ladders[i].split(",");
                int v = Integer.parseInt(edge[0]);
                int u = Integer.parseInt(edge[1]);
                g.addEdge(v, u);
            }

            String[] snakes = reader.readLine().split(" ");
            for (int i = 0; i < snake; i++) {
                String[] edge = snakes[i].split(",");
                int v = Integer.parseInt(edge[0]);
                int u = Integer.parseInt(edge[1]);
                g.addEdge(v, u);
            }

            for (int i = 1; i < 100; i++) {
                if (g.adj(i).isEmpty()) {
                    for (int j = i + 1; j <= i + 6 && j <= 100; j++) {
                        g.addEdge(i, j);
                    }
                }
            }
            g.bfs(1);
            writer.println(g.distance(100) - 1);

        }
        writer.flush();
        writer.close();
    }

}
