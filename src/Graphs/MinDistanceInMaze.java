package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceInMaze {
    public static void main (String[] args) {
        int[][] maze = {
                {0, 0},
                {0, 1}
        };
        int[] start = new int[]{0, 0};
        int[] end = new int[]{0, 1};
        System.out.println("Minimum distance between start and end :: " + calculateMinDistance(maze, start, end));
    }

    public static int calculateMinDistance (int[][] maze, int[] start, int[] end) {

        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, - 1}, {- 1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        while (! q.isEmpty()) {
            int[] currPoint = q.poll();
            for (int[] dir : dirs) {
                int x = currPoint[0] + dir[0];
                int y = currPoint[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[x - dir[0]][y - dir[1]] > distance[currPoint[0]][currPoint[1]] + count) {
                    distance[x - dir[0]][y - dir[1]] = distance[currPoint[0]][currPoint[1]] + count;
                    q.offer(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[end[0]][end[1]] == Integer.MAX_VALUE ? - 1 : distance[end[0]][end[1]];
    }
}
