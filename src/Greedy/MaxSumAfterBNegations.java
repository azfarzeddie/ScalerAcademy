package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSumAfterBNegations {
    public static void main (String[] args) {
        int[] nums = new int[]{57, 3, - 14, - 87, 42, 38, 31, - 7, - 28, - 61};
        int B = 10;
        System.out.println("Maximum sum of array :: " + getMaxSumAfterNegations(nums, B));
    }

    public static int getMaxSumAfterNegations (int[] nums, int B) {
        int sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < B; i++) {
            int ele = priorityQueue.poll();
            ele *= - 1;
            priorityQueue.offer(ele);
        }
        while (! priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }
        return sum;
    }
}
