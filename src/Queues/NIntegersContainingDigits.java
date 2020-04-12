package Queues;

import Util.ScalerUtils;

import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContainingDigits {
    static ScalerUtils utils = new ScalerUtils();
    public static int[] solve(int A) {
        Queue<Integer> queue= new LinkedList<>();
        int[] res = new int[A];
        queue.add(1);
        queue.add(2);
        queue.add(3);
        for(int i=0;i<A;i++) {
            int ele = queue.remove();
            res[i] = ele;
            int ele1 = ele * 10 + 1;
            int ele2 = ele * 10 + 2;
            int ele3 = ele * 10 + 3;
            if(i!= (A-1)) {
                queue.add(ele1);
                queue.add(ele2);
                queue.add(ele3);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int A = 7;
        utils.printArray(solve(A));
    }
}
