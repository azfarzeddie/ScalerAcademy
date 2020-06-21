package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DistributeCandy {
    public static void main (String[] args) {
        int[] ratings = new int[]{1, 5, 2, 1};
        System.out.println("Total candies distributed :: " + totalCandiesDistributed(ratings));
    }

    public static int totalCandiesDistributed (int[] ratings) {
        int totalCandies = 0;
        int[] resArray = new int[ratings.length];
        Arrays.fill(resArray, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                resArray[i] = resArray[i - 1] + 1;
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                resArray[i] = Math.max(resArray[i], resArray[i + 1] + 1);
        for (int i = 0; i < resArray.length; i++)
            totalCandies += resArray[i];
        return totalCandies;
    }

}
