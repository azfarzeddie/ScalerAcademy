package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    static final int MODULO = 10000003;

    public static void main (String[] args) {
        String seats = "....x..xx...x..";
        System.out.println("Number of jumps required :: " + getMinimumJumps(seats));
    }

    public static int getMinimumJumps (String seats) {
        List<Integer> occupiedIndexes = new ArrayList<>();
        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == 'x')
                occupiedIndexes.add(i);
        }
        if (occupiedIndexes.size() == 0)
            return 0;
        int medianIndex = occupiedIndexes.size() / 2;
        int median = occupiedIndexes.get(medianIndex);
        int totalJumps = 0;
        for (int i = 0; i < occupiedIndexes.size(); i++) {
            totalJumps = (totalJumps + Math.abs((median - medianIndex + i) - occupiedIndexes.get(i))) % MODULO;
        }

        return totalJumps;
    }
}
