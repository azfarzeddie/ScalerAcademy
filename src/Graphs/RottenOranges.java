package Graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RottenOranges {
    public static void main (String[] args) {
        int[][] matrix = new int[][]{
                {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
                {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
                {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
                {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
                {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
                {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}
        };
        System.out.println("Time before everything is rotten :: " + timeToRot(matrix));
    }

    public static int timeToRot (int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;
        // multi-source BFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    countFresh++;
            }
        }
        if (countFresh == 0) return 0;
        int count = 0;
        // to check in left right top bottom cells
        int[][] dirs = {{1, 0}, {- 1, 0}, {0, 1}, {0, -1}};
        while (! queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                for (int[] dir : dirs) {
                    // new location
                    int x = location[0] + dir[0];
                    int y = location[1] + dir[1];
                    // overflow, underflow, already rotten, empty to be ignored
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? count - 1 : - 1;
    }
}
