package Heaps;

import Util.ScalerUtils;

import java.util.*;

public class NMaxPairCombination {
    static ScalerUtils scalerUtils = new ScalerUtils();

    public static void main (String[] args) {
        int[] A = new int[]{1, 4, 2, 3};
        int[] B = new int[]{2, 5, 1, 6};

        scalerUtils.printArray(solve(A, B));
    }

    public static int[] solve (int[] A, int[] B) {
        int[] res = new int[A.length];
        int k = 0;
        Integer[] AI = Arrays.stream(A).boxed().toArray(Integer[] :: new);
        Integer[] BI = Arrays.stream(B).boxed().toArray(Integer[] :: new);
        Arrays.sort(AI, Collections.reverseOrder());
        Arrays.sort(BI, Collections.reverseOrder());
        scalerUtils.printArray(AI);
        scalerUtils.printArray(BI);

        if (AI == null || BI == null || AI.length == 0 || BI.length == 0) return res;
        Set<String> set = new HashSet<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare (Pair o1, Pair o2) {
                return Integer.compare(o2.sum, o1.sum);
            }
        });
        Pair p = new Pair(AI[0] + BI[0], 0, 0);
        queue.offer(p);
        set.add(p.idxA + "" + p.idxB);
        int i = 0, j = 0;
        while (k < AI.length - 1) {
            if (! queue.isEmpty()) {
                Pair pair = queue.poll();
                res[k] = pair.sum;
                i = pair.idxA;
                j = pair.idxB;
                k++;
                if (! set.contains((i + 1) + "," + j)) {
                    queue.add(new Pair(AI[i + 1] + BI[j], i + 1, j));
                    set.add((i + 1) + "" + j);
                }
                if (! set.contains(i + "," + (j + 1))) {
                    queue.add(new Pair(AI[i] + BI[j + 1], i, j + 1));
                    set.add(i + "" + (j + 1));
                }
            }
        }
        res[k] = queue.poll().sum;
        return res;
    }

    public static class Pair {
        public int sum;
        public int idxA, idxB;

        Pair (int sum, int idxA, int idxB) {
            this.idxA = idxA;
            this.idxB = idxB;
            this.sum = sum;
        }
    }
}
