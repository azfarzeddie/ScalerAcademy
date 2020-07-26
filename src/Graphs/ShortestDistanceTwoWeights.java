package Graphs;

import java.util.*;

public class ShortestDistanceTwoWeights {
    public static void main (String[] args) {
        int vertices = 10;
        int[][] graph = {
                {3, 8, 2},
                {3, 5, 1},
                {1, 7, 2},
                {6, 9, 2},
                {0, 7, 2},
                {3, 9, 1},
                {0, 8, 2},
                {0, 5, 2},
                {0, 3, 1}
        };
        int source = 2;
        int destination = 3;
        System.out.println("Shortest path between source and destination :: " + getShortestPath(vertices, graph, source, destination));
    }

    public static int getShortestPath (int vertices, int[][] graph, int source, int destination) {
        int weight = - 1;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i][2] == 1) {
                map.putIfAbsent(graph[i][0], new ArrayList<>());
                map.get(graph[i][0]).add(graph[i][1]);
                map.putIfAbsent(graph[i][1], new ArrayList<>());
                map.get(graph[i][1]).add(graph[i][0]);
            } else if (graph[i][2] == 2) {
                map.putIfAbsent(graph[i][0], new ArrayList<>());
                map.get(graph[i][0]).add(vertices);
                map.putIfAbsent(vertices, new ArrayList<>());
                map.get(vertices).add(graph[i][1]);
                map.putIfAbsent(graph[i][1], new ArrayList<>());
                map.get(graph[i][1]).add(vertices);
                map.putIfAbsent(vertices, new ArrayList<>());
                map.get(vertices).add(graph[i][0]);
                vertices++;
            }
        }
        System.out.println(map.toString());
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        visited[source] = true;
        q.add(new int[]{source, 0});
        while (! q.isEmpty()) {
            int[] temp = q.poll();
            int hops = temp[1];
            if (temp[0] == destination) {
                weight = temp[1];
                return weight;
            }
            if (map.get(temp[0]) != null && map.get(temp[0]).size() != 0)
                for (Integer ele : map.get(temp[0])) {
                    if (! visited[ele]) {
                        visited[ele] = true;
                        q.offer(new int[]{ele, hops + 1});
                    }
                }
        }
        return weight;
    }
}
