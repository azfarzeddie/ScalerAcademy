package Graphs;

import java.util.*;

public class SmallestMultipleWith01 {
    public static void main (String[] args) {
        int num = 55;
        System.out.println("Multiple is :: " + getSmallestBinaryMultiple(num));
    }

    public static String getSmallestBinaryMultiple (int num) {
        StringBuilder sb = new StringBuilder("1");
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(new Pair(sb.toString(), 1));
        while (! queue.isEmpty()) {
            String ele = queue.peek().number;
            int lastRemainder = queue.peek().lastRemainder;
            sb = new StringBuilder(ele);
            queue.poll();
            if (lastRemainder == 0)
                return sb.toString();
            else {
                int rem0 = modulo('0', lastRemainder, num);
                int rem1 = modulo('1', lastRemainder, num);
                if (!set.contains(rem0)) {
                    set.add(rem0);
                    queue.offer(new Pair(sb.append("0").toString(), rem0));
                    sb.deleteCharAt(sb.length()-1);
                }
                if (!set.contains(rem1)) {
                    set.add(rem1);
                    queue.offer(new Pair(sb.append("1").toString(), rem1));
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return null;
    }

    static int modulo (char t, int rem, int N) {
        rem = rem * 10 + Character.getNumericValue(t);
        rem %= N;
        return rem;
    }

    static class Pair {
        String number;
        int lastRemainder;

        Pair (String str, int rem) {
            number = str;
            lastRemainder = rem;
        }
    }
}
