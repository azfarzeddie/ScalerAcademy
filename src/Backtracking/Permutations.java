package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main (String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println("Permutations :: " + permute(arr));
    }

    public static List<List<Integer>> permute (int[] nums) {
        List<Integer> subList = new ArrayList<>();
        helper(nums, 0, subList);
        return list;
    }

    public static void helper (int[] nums, int index, List<Integer> subList) {
        if (nums == null || nums.length == 0) return;
        if (subList.size() == nums.length)
            list.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            subList.add(nums[i]);
            helper(nums, i + 1, subList);
            subList.remove(new Integer(nums[i]));
        }
    }
}
