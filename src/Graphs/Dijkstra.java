package Graphs;

import Util.ScalerUtils;

import java.util.*;

public class Dijkstra {
    static ScalerUtils scalerUtils = new ScalerUtils();

    public static void main (String[] args) {
        int edges = 6;
        // undirected
        int[][] connections = {
                {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}
        };
        int source = 4;
        scalerUtils.printArray(getMinimumDistance(edges, connections, source));
    }

    public static int[] getMinimumDistance (int edges, int[][] connections, int source) {
            int[] distance = new int[edges];
            boolean[] visited = new boolean[edges];
            PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare (Pair o1, Pair o2) {
                    return Integer.compare(o1.distance, o2.distance);
                }
            });
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] conn : connections) {
                map.putIfAbsent(conn[0], new HashMap<>());
                map.get(conn[0]).put(conn[1], conn[2]);
                map.putIfAbsent(conn[1], new HashMap<>());
                map.get(conn[1]).put(conn[0], conn[2]);
            }
            Arrays.fill(distance, Integer.MAX_VALUE);
            q.offer(new Pair(0, source));
            distance[source] = 0;
            while (! q.isEmpty()) {
                Pair curr = q.poll();
                int node = curr.node;
                int dist = curr.distance;
                if (map.containsKey(node)) {
                    for (int mapNode : map.get(node).keySet()) {
                        if (distance[mapNode] > distance[node] + map.get(node).get(mapNode)) {
                            distance[mapNode] = distance[node] + map.get(node).get(mapNode);
                            q.offer(new Pair(dist + map.get(node).get(mapNode), mapNode));
                        }
                    }
                }
            }
            return distance;
        }

        static class Pair {
            int distance;
            int node;

            Pair (int _d, int _n) {
                distance = _d;
                node = _n;
            }

            @Override
            public String toString () {
                return "Pair{" + "distance=" + distance + ", node=" + node + '}';
            }
        }
}
