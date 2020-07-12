package Graphs;

import java.util.ArrayList;

public class BlackShapes {
    public static void main (String[] args) {
        String[] board = {"XXX", "XXX", "XXX"};
        System.out.println("No. of black shapes :: " + getCountBlackShapes(board));
    }

    static int[][] dirs = {{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}};

    public static int getCountBlackShapes (String[] array) {
        int count = 0;
        if (array == null || array.length == 0)
            return 0;
        int rows = array.length;
        int cols = array[0].length();
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < array.length; i++) {
            char[] arr = array[i].toCharArray();
            matrix[i] = arr;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'X') {
                    explore(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void explore (char[][] matrix, int x, int y) {
        matrix[x][y] = 'D';

        for (int[] dir : dirs) {
            if (x + dir[0] < matrix.length && x + dir[0] >= 0 && y + dir[1] < matrix.length && y + dir[1] >= 0 && matrix[x + dir[0]][y + dir[1]] == 'X') {
                explore(matrix, x + dir[0], y + dir[1]);
            }
        }
    }
}
