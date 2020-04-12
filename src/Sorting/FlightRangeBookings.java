package Sorting;

import Util.ScalerUtils;

public class FlightRangeBookings {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(flightBookings(A));
    }
    public static int[] flightBookings(int[][] A) {
        int len = A.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++) {
            max = Math.max(max, A[i][1]);
        }
        System.out.println("max is "+max);
        int[] res = new int[max];
        for(int i=0;i<len;i++) {
            for(int j=A[i][0];j<=A[i][1];j++) {
                res[j-1]+=A[i][2];
            }
        }
        return res;
    }
}
