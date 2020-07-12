package Backtracking;

public class Sixlets {
    private static int result = 0;

    public static void main (String[] args) {
        int[] arr = new int[]{1, 2, 8};
        int num = 2;
        System.out.println("Sixlets :: " + generateSixlets(arr, num));
    }

    public static int generateSixlets (int[] nums, int num) {
        util(nums, num, 0, 0, 0);
        return result;
    }

    public static void util (int[] nums, int num, int sum, int count, int idx) {
        if (count == num && sum <= 1000) {
            result++;
            return;
        }
        if (sum > 1000)
            return;
        if (idx == nums.length)
            return;

        util(nums, num, sum + nums[idx], count+1, idx+1);
        util(nums, num, sum, count, idx+1);
    }
}
