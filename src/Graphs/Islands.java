package Graphs;

public class Islands {
    public static void main (String[] args) {
        int[][] maze = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("No. of islands :: " + countIslands(maze));
    }

    public static int countIslands (int[][] maze) {
        int count = 0;
        if (maze.length == 0) return 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    obliterateIsland(i, j, maze);
                    count++;
                }
            }
        }
        return count;
    }

    public static void obliterateIsland (int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != 1) return;
        maze[x][y] = 0;
        obliterateIsland(x, y + 1, maze); // right
        obliterateIsland(x + 1, y, maze); // down
        obliterateIsland(x, y - 1, maze); // left
        obliterateIsland(x - 1, y, maze); // up
        obliterateIsland(x - 1, y - 1, maze); // left up diagonal
        obliterateIsland(x + 1, y + 1, maze); // right down diagonal
        obliterateIsland(x - 1, y + 1, maze); // left down diagonal
        obliterateIsland(x + 1, y - 1, maze); // right up diagonal
    }
}
