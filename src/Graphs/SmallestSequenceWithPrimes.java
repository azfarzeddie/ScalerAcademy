package Graphs;

import Util.ScalerUtils;

import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class SmallestSequenceWithPrimes {
    public static void main (String[] args) {
        int A = 3;
        int B = 11;
        int C = 7;
        int D = 50;
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(smallestSequence(A, B, C, D));
    }

    public static int[] smallestSequence (int A, int B, int C, int D) {
        SortedSet<Integer> q = new TreeSet<>();
        q.add(A);
        q.add(B);
        q.add(C);
        int[] res = new int[D];
        int k = 0;
        if (D == 0) return res;
        while (! q.isEmpty()) {
            int curr = q.first();
            q.remove(q.first());
            res[k] = curr;
            k++;
            if (k==D)
                break;
            q.add(curr * A);
            q.add(curr * B);
            q.add(curr * C);
            System.out.println("value of k :: " + k);
        }
        return res;
    }
}
