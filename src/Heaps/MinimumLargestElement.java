package Heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class MinimumLargestElement {
    public static void main (String[] args) {
        int[] arr = new int[]{- 2, - 4, - 8, - 16};
        int opers = 10;
        System.out.println("Minimum largest element is :: " + MinLargestEle(arr, opers));
    }

    public static int MinLargestEle (int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare (Pair o1, Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        // preparing the initial heap
        for (int i = 0; i < nums.length; i++) {
            int num = 2 * nums[i];
            heap.add(new Pair(num, i));
        }

        int[] futureArray = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < k; i++) {
            Pair pair = heap.poll();
            int smallestVal = pair.value;
            int smallestIndex = pair.index;
            futureArray[smallestIndex] = smallestVal;
            smallestVal += nums[smallestIndex];
            heap.add(new Pair(smallestVal, smallestIndex));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < futureArray.length; i++) {
            max = Math.max(max, futureArray[i]);
        }
        return max;
    }

    static class Pair {
        int value;
        int index;

        Pair (int _value, int _index) {
            value = _value;
            index = _index;
        }
    }
}

