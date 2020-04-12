package Arrays;

import Util.ScalerUtils;

public class RainWaterTrapped {
    static ScalerUtils utils = new ScalerUtils();
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(solve( arr ));
    }

    public static int solve(int[] A) {
        int maxleft = A[0], maxright = A[A.length-1];
        int[] leftmax = new int[A.length];
        int[] rightmax = new int[A.length];
        for(int i=0;i<A.length;i++) {
            leftmax[i] = Math.max(maxleft, A[i]);
            maxleft = Math.max(maxleft, leftmax[i]);
        }
        utils.printArray( leftmax );
        for(int i=A.length-1;i>=0;i--) {
            rightmax[i] = Math.max(maxright, A[i]);
            maxright = Math.max(maxright, rightmax[i]);
        }
        utils.printArray( rightmax );
        utils.printArray( A );
        int res = 0;
        for(int i=0;i<A.length;i++) {
            res += Math.abs(Math.min(leftmax[i],rightmax[i])-A[i]);
        }
        return res;
    }
}
