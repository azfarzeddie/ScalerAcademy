package Graphs;

import Util.ScalerUtils;

import java.util.LinkedList;
import java.util.Queue;

public class NearestOne {
    public static void main (String[] args) {
        int[][] nums = {
                {1, 1, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printIntegerMatrix(getNearestOnes(nums));
    }

    public static int[][] getNearestOnes (int[][] nums) {
        if (nums == null || nums.length == 0) return null;
        int rows = nums.length;
        int cols = nums[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {- 1, 0}, {0, 1}, {0, - 1}};
        // put all 1's in the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nums[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    nums[i][j] = - 1;
                }
            }
        }

        while (! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < nums.length && y < nums[0].length) {
                        if (nums[x][y] == 0) {
                            //  |x1 - y1| + |x2 - y2|.
                            nums[x][y] = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (nums[i][j] == - 1) {
                    nums[i][j] = 0;
                }
            }
        }

        return nums;
    }
}
