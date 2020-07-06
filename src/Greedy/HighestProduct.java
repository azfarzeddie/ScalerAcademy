package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;


public class HighestProduct {
    public static void main (String[] args) {
        int[] nums = new int[]{-30, - 40, 3, 1, 70, 500};
        System.out.println("Highest possible product of array :: " + getHighestProduct(nums));
    }

    public static int getHighestProduct (int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int max = nums[l-1]*nums[l-2]*nums[l-3];
        max = Math.max(max, nums[l-1]*nums[0]*nums[1]);
        return max;
    }

}
