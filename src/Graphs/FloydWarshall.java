package Graphs;

import Util.ScalerUtils;

public class FloydWarshall {
    static ScalerUtils scalerUtils = new ScalerUtils();

    public static void main (String[] args) {
        int[][] matrix = {
                {0, 50, 39},
                {- 1, 0, 1},
                {- 1, 10, 0}
        };
        scalerUtils.printIntegerMatrix(getShortestPairwiseDist(matrix));
    }

    public static int[][] getShortestPairwiseDist (int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[i][j] == -1)
                    A[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < A.length; k++) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (A[i][j] > A[i][k] + A[k][j])
                        A[i][j] = A[i][k] + A[k][j];
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[i][j] == Integer.MAX_VALUE)
                    A[i][j] = -1;
            }
        }
        return A;
    }
}
