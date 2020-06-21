package Greedy;

import java.util.Arrays;

public class AssignMiceToHoles {
    public static void main (String[] args) {
        int[] mice = new int[]{- 4, 2, 3};
        int[] holes = new int[]{0, - 2, 4};
        System.out.println("Minimum time required :: " + getMinimumTime(mice, holes));
    }

    public static int getMinimumTime (int[] mice, int[] holes) {
        int totaltime = 0;
        Arrays.sort(mice);
        Arrays.sort(holes);
        for (int i = 0; i < mice.length; i++) {
            totaltime = Math.max(totaltime, Math.abs(mice[i] - holes[i]));
        }
        return totaltime;
    }
}
