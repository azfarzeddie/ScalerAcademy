package Arrays;

import Util.ScalerUtils;

public class AltPosNeg {
    public static void main(String[] args) {
        int[] arr = {5, -17, -100, -11};
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray( solve( arr ) );
    }

    public static int[] solve(int[] A) {
        int countpos = 0, countneg = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>=0) countpos++;
            else if(A[i]<0) countneg++;
        }
        int[] pos = new int[countpos];
        int[] neg = new int[countneg];
        int kpos = 0, kneg = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>=0) {
                pos[kpos] = A[i];
                kpos++;
            } else {
                neg[kneg] = A[i];
                kneg++;
            }
        }
        kneg=-1;
        kpos=-1;
        int[] res = new int[A.length];
        for(int i=0;i<2*Math.min( countneg,countpos );i++) {
            if(i%2==0)
                res[i] = neg[++kneg];
            else if(i%2==1)
                res[i] = pos[++kpos];
        }
        for(int i=2*Math.min( countneg,countpos );i<res.length;i++) {
            if(countneg < countpos) {
                res[i] = pos[++kpos];
            } else if(countpos < countneg) {
                res[i] = neg[++kneg];
            }
        }
        return res;
    }
}
