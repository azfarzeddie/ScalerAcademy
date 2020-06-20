package Heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public static void main (String[] args) {
        int timeUnits = 10;
        int[] chocolates = new int[]{2147483647, 2000000014, 2147483647};
        System.out.println("Maximum chocolates eaten :: " + maxChocolatesEaten(timeUnits, chocolates));
    }

    public static int maxChocolatesEaten (int timeUnits, int[] chocolates) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < chocolates.length; i++) {
            priorityQueue.offer(chocolates[i]);
        }
        long eaten = 0;
        for (int i = 0; i < timeUnits; i++) {
            int ele = priorityQueue.poll();
            eaten = (eaten % 1000000007 + ele % 1000000007) % 1000000007;
            priorityQueue.offer((int) Math.floor(ele / 2));
        }
        return (int) eaten % 1000000007;
    }
}
