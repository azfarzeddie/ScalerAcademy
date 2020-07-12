package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegionsOnBoard {
    public static void main (String[] args) {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        ArrayList<Character> list = new ArrayList<>();
        list.add('X');
        list.add('X');
        list.add('X');
        list.add('X');
        board.add(new ArrayList<>(list));
        list.clear();
        list.add('X');
        list.add('O');
        list.add('O');
        list.add('X');
        board.add(new ArrayList<>(list));
        list.clear();
        list.add('X');
        list.add('X');
        list.add('O');
        list.add('X');
        board.add(new ArrayList<>(list));
        list.clear();
        list.add('X');
        list.add('O');
        list.add('X');
        list.add('X');
        board.add(new ArrayList<>(list));
        System.out.println("Original board :: " + board);
        occupyBoard(board);
        System.out.println("Occupied board :: " + board);
    }

    public static void occupyBoard (ArrayList<ArrayList<Character>> board) {
        // identify all the border O's. Then identify all O's connected to border O's
        // these are the ones which cannot be converted to X's
        if (board == null || board.size() == 0) return;
        int rows = board.size();
        int cols = board.get(0).size();
        int[][] dirs = {{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || j == 0 || i == board.size()-1 || j == board.get(0).size()-1) && board.get(i).get(j) == 'O') {
                    // border O found
                    Queue<int[]> queue = new LinkedList<>();
                    board.get(i).set(j, 'D');
                    queue.offer(new int[]{i, j});
                    while (! queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + dirs[k][0];
                            int y = point[1] + dirs[k][1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols && board.get(x).get(y) == 'O') {
                                board.get(x).set(y, 'D');
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Current board :: " + board);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board.get(i).get(j) == 'D')
                    board.get(i).set(j, 'O');
                else if (board.get(i).get(j) == 'O')
                    board.get(i).set(j, 'X');
            }
        }
    }
}
