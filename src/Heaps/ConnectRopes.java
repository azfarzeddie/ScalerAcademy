package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class ConnectRopes {
    public static void main (String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("Minimum cost :: " + MinimizeCost(arr));
    }

    public static int MinimizeCost (int[] nums) {
        /*
        build a min heap using the elements of the array. extract two smallest numbers,
        sum them up and re-insert
         */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < nums.length; i++)
            minHeap.offer(nums[i]);

        System.out.println("Size :: " + minHeap.size());
        System.out.println(Arrays.toString(minHeap.toArray()));
        int ropeOne = 0, ropeTwo = 0, res = 0;
        while (! minHeap.isEmpty() && ! (minHeap.size() == 1)) {
            // System.out.println("Loop :: " + Arrays.toString(minHeap.toArray()) + "Size :: " + minHeap.size());
            ropeOne = minHeap.poll();
            ropeTwo = minHeap.poll();
            res += ropeOne + ropeTwo;
            minHeap.add(ropeOne + ropeTwo);
        }
        return res;
    }
}
