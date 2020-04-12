package Queues;

import Util.ScalerUtils;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInWindow {
    static ScalerUtils utils = new ScalerUtils();
    public static int[] solve(int[] A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[A.length-B+1];
        int k=0;
        for(int i=0;i<B;i++) {
            if(A[i]<0)
                deque.addLast(i);
        }
        System.out.println("deque is "+deque);
        for(int i=B;i<A.length;i++) {
            if(!deque.isEmpty()) {
                res[k] = A[deque.peekFirst()];
                utils.printArray(res);
            } else {
                res[k] = 0;
                utils.printArray(res);
            }
            while(!deque.isEmpty() && deque.peekFirst()<(i-B+1)) {
                System.out.println("inside while");
                deque.removeFirst();
                System.out.println("deque is "+deque);
            }
            if(A[i]<0) {
                System.out.println("adding to deque");
                deque.addLast(i);
            }
            k++;
            System.out.println("deque is "+deque);
        }
        if(!deque.isEmpty()) {
            res[k] = A[deque.peekFirst()];
        } else {
            res[k] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, -4, 5};
        utils.printArray(solve(arr, 2));
    }
}
