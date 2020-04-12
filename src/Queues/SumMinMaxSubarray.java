package Queues;

import Util.ScalerUtils;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinMaxSubarray {
    static int start = 0, sum = 0;
    static ScalerUtils utils = new ScalerUtils();
    public static int solve(int[] A, int B) {
        int[] max, min;
        System.out.println("Calling for max");
        max = SubarrayMinMax(A, B, 1);
        System.out.println("Max array is ");
        utils.printArray(max);
        System.out.println("Calling for min");
        min = SubarrayMinMax(A, B, 2);
        System.out.println("Min array is ");
        utils.printArray(min);
        for(int i=0;i<max.length;i++) {
            sum = (sum + max[i]+min[i]) % 1000000007;
        }
        return sum;
    }

    public static int[] SubarrayMinMax(int[] A, int B, int operationType) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[A.length-B+1];
        int idx = 0;
        System.out.println("Deque is "+deque);
        while(start != (A.length-B+1)) {
            for(int i=0;i<B;i++) {
                idx = start+i;
                if(operationType == 1) {
                    if(deque.isEmpty() || A[idx] > deque.peekLast()) {
                        deque.addLast(A[idx]);
                    } else {
                        while(!deque.isEmpty() && A[idx] <= deque.peekLast())
                            deque.removeLast();
                        deque.addLast(A[idx]);
                    }
                } else if (operationType == 2) {
                    if(deque.isEmpty() || A[idx] < deque.peekLast()) {
                        deque.addLast(A[idx]);
                    } else {
                        while(!deque.isEmpty() && A[idx] >= deque.peekLast())
                            deque.removeLast();
                        deque.addLast(A[idx]);
                    }
                }
            }
            res[start] = deque.peekFirst();
            start++;
            if(deque.peekFirst() < start)
                deque.removeFirst();
        }
        start = 0;
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        int B = 4;
        System.out.println("sum is "+solve(A, B));
    }
}
