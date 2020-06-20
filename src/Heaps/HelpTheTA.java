package Heaps;

import Util.ScalerUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HelpTheTA {
    public static void main (String[] args) {
        int[] mistakes = new int[]{2, 10, 5, 1, 1};
        int minutes = 46;
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(doubtsSolvedByMinute(mistakes, minutes));
    }

    public static int[] doubtsSolvedByMinute (int[] mistakes, int minutes) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare (Pair o1, Pair o2) {
                if (o1.mistakeCount != o2.mistakeCount)
                    return Integer.compare(o2.mistakeCount, o1.mistakeCount);
                else
                    return o1.rollNo < o2.rollNo ? - 1 : 1;
            }
        });

        int sum = 0;
        for (int i = 0; i < mistakes.length; i++) {
            priorityQueue.offer(new Pair(i, mistakes[i]));
            sum += mistakes[i];
            System.out.println("Inserted :: " + i + " " + mistakes[i]);
        }

        int[] resArray = new int[Math.min(minutes, sum)];
        for (int i = 0; i < resArray.length; i++) {
            Pair tempPair = priorityQueue.poll();
            System.out.println("Temp Pair :: " + tempPair.rollNo + " " + tempPair.mistakeCount);
            int mistake = tempPair.mistakeCount;
            resArray[i] = tempPair.rollNo;
            priorityQueue.offer(new Pair(tempPair.rollNo, mistake - 1));
        }
        return resArray;
    }

    static class Pair {
        int rollNo;
        int mistakeCount;

        Pair (int _rollNo, int _mistakeCount) {
            rollNo = _rollNo;
            mistakeCount = _mistakeCount;
        }
    }
}
