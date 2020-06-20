package Heaps;

import Util.ScalerUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AthLargestElement {
    public static void main (String[] args) {
        int A = 2;
        int[] B = new int[]{15, 20, 99, 1};
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(getAthMaxElementArray(A, B));
    }

    public static int[] getAthMaxElementArray (int A, int[] B) {
        int[] resArray = new int[B.length];
        loopUtil(B, resArray, A);
        return resArray;
    }

    public static void loopUtil (int[] arr, int[] res, int A) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < A; i++) {
            priorityQueue.offer(arr[i]);
            if (i != A - 1)
                res[i] = - 1;
            else
                res[i] = priorityQueue.peek();
        }

        for (int i = A; i < arr.length; i++) {
            if (! priorityQueue.isEmpty() && priorityQueue.peek() < arr[i]) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
                res[i] = priorityQueue.peek();
            } else {
                res[i] = priorityQueue.peek();
            }
        }
    }
}
