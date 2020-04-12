package Queues;

import Util.ScalerUtils;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseBElements {
    static ScalerUtils utils = new ScalerUtils();
    public static int[] solve(int[] A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<B;i++) {
            System.out.println("current deque: "+deque);
            System.out.println("Adding element to front of deque");
            deque.addFirst(A[i]);
            System.out.println("new deque: "+deque);
        }
        for(int i=B;i<A.length;i++) {
            System.out.println("current deque: "+deque);
            System.out.println("Adding element to end of deque");
            deque.addLast(A[i]);
            System.out.println("new deque: "+deque);
        }
        Object[] arr = deque.toArray();
        for(int i=0;i<arr.length;i++) {
            A[i] = (int)arr[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr = {43, 35, 25, 5, 34, 5, 8, 7};
        utils.printArray(solve(arr,6));
    }
}
