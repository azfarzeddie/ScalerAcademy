package Greedy;

import Util.ScalerUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheShipCompany {
    public static void main (String[] args) {
        int A = 4;
        int B = 3;
        int[] places = new int[]{2, 2, 2};
        System.out.println("Minimum and Maximum price :: ");
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(getPriceArray(A, B, places));
    }

    public static int[] getPriceArray (int A, int B, int[] places) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int i = 0; i < places.length; i++) {
            minPriorityQueue.offer(places[i]);
            maxPriorityQueue.offer(places[i]);
        }
        
        int sumMin = 0, sumMax = 0;
        for (int i = 0; i < A; i++) {
            int ele = minPriorityQueue.poll();
            sumMin += ele;
            if (ele != 1)
                minPriorityQueue.offer(ele - 1);
            ele = maxPriorityQueue.poll();
            sumMax += ele;
            if (ele != 1)
                maxPriorityQueue.offer(ele - 1);
        }

        int[] result = new int[2];
        result[0] = sumMax;
        result[1] = sumMin;

        return result;
    }
}
