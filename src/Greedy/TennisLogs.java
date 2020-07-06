package Greedy;

import java.util.ArrayList;
import java.util.List;

public class TennisLogs {
    public static void main (String[] args) {
        int A = 3;
        int[] B = new int[]{1, 2, 1};
        System.out.println("Is this a valid log :: " + getLogValidity(A, B));
    }

    public static String getLogValidity (int A, int[] B) {
        List<Integer> currPlayers = new ArrayList<>();
        currPlayers.add(1);
        currPlayers.add(2);
        for (int i = 0; i < A; i++) {
            if (! currPlayers.contains(B[i]))
                return "No";
            int loser = currPlayers.get(currPlayers.size() - currPlayers.indexOf(B[i]) - 1);
            int indexOfLoser = currPlayers.size() - currPlayers.indexOf(B[i]) - 1;
            int newPlayer = 6 - (currPlayers.get(0) + currPlayers.get(1));
            currPlayers.clear();
            currPlayers.add(newPlayer);
            currPlayers.add(B[i]);
        }
        return "Yes";
    }
}
