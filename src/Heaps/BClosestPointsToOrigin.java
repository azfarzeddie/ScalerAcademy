package Heaps;

import Util.ScalerUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BClosestPointsToOrigin {
    public static void main (String[] args) {
        int[][] points = {{1, - 1}, {2, - 1}};
        int k = 1;
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printIntegerMatrix(getKClosestPoints(points, k));
    }

    public static int[][] getKClosestPoints (int[][] points, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare (Pair o1, Pair o2) {
                double diffo1 = (Math.pow(o1.xval, 2) + Math.pow(o1.yval, 2));
                double diffo2 = (Math.pow(o2.xval, 2) + Math.pow(o2.yval, 2));
                return Double.compare(diffo2, diffo1);
            }
        });
            for (int i = 0; i < k; i++) {
                priorityQueue.offer(new Pair(points[i][0], points[i][1]));
            }
            for (int i = k; i < points.length; i++) {
                if ((int) Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)) <
                        (int) Math.sqrt(Math.pow(priorityQueue.peek().xval, 2) + Math.pow(priorityQueue.peek().yval, 2))) {
                    priorityQueue.offer(new Pair(points[i][0], points[i][1]));
                }
            }
        int[][] resMatrix = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair tempPair = priorityQueue.poll();
            resMatrix[i][0] = tempPair.xval;
            resMatrix[i][1] = tempPair.yval;
        }
        return resMatrix;
    }

    static class Pair {
        int xval;
        int yval;

        Pair (int _xval, int _yval) {
            xval = _xval;
            yval = _yval;
        }
    }
}
