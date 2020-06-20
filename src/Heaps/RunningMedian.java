package Heaps;

import Util.ScalerUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main (String[] args) {
        int[] stream = new int[]{1, 2, 5, 4, 3};
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(getRunningMedianArray(stream));
    }

    public static int[] getRunningMedianArray (int[] stream) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare (Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        int[] resArray = new int[stream.length];
        maxHeap.add(stream[0]);
        int median = maxHeap.peek();
        resArray[0] = median;
        for (int i = 1; i < stream.length; i++) {
            if (median < stream[i])
                minHeap.offer(stream[i]);
            else if (median >= stream[i])
                maxHeap.offer(stream[i]);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
            if (minHeap.size() == maxHeap.size())
                median = Math.min(minHeap.peek(), maxHeap.peek());
            else if (minHeap.size() > maxHeap.size())
                median = minHeap.peek();
            else if (maxHeap.size() > minHeap.size())
                median = maxHeap.peek();

            resArray[i] = median;
        }
        return resArray;
    }
}
