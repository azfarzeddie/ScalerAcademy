package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightMovement {
    public static void main (String[] args) {
        int A = 8, B = 8, C = 1, D = 1, E = 8, F = 8;
        System.out.println("Minimum moves required by knight :: " + getMinMovesByKnight(A, B, C, D, E, F));
    }

    public static int getMinMovesByKnight (int A, int B, int C, int D, int E, int F) {
        int[][] dirs = {{1, 2}, {2, 1}, {2, - 1}, {1, - 2}, {- 1, 2}, {- 2, 1}, {- 2, - 1}, {- 1, - 2}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[A+1][B+1];
        visited[C][D] = true;
        q.add(new int[]{C, D, 0});
        while (! q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            if (x == E && y == F) {
                return temp[2];
            }
            for (int[] point : dirs) {
                x = temp[0] + point[0];
                y = temp[1] + point[1];
                if (x >= 1 && y >= 1 && x <= A && y <= B && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y, temp[2] + 1});
                }
            }
        }
        return -1;
    }
}
