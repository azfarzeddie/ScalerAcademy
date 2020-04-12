package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval ob1 = new Interval(1, 10);
        Interval ob2 = new Interval(2, 9);
        Interval ob3 = new Interval(3, 8);
        Interval ob4 = new Interval(4, 7);
        Interval ob5 = new Interval(5, 6);
        Interval ob6 = new Interval(6, 6);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(ob1);
        list.add(ob2);
        list.add(ob3);
        list.add(ob4);
        list.add(ob5);
        list.add(ob6);
        System.out.println("res::" + merge(list));
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int len = intervals.size();
        ArrayList<Interval> res = new ArrayList<>();
        Stack<Interval> stack = new Stack<>();
        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start)
                    return 1;
                else if (o1.start < o2.start)
                    return -1;
                else
                    return 0;
            }
        };
        //System.out.println(intervals.toString());
        intervals.sort(intervalComparator);
        //System.out.println(intervals.toString());
        Interval object = new Interval();

        object = new Interval(intervals.get(0).start, intervals.get(0).end);
        stack.push(object);

        for (int i = 0; i < len; i++) {
            object = new Interval(intervals.get(i).start, intervals.get(i).end);
            //System.out.println("stack :: " + stack);
            //System.out.println("current object :: " + object);
            if (!stack.isEmpty() && intervals.get(i).start >= stack.peek().start && intervals.get(i).start <= stack.peek().end) {
                object = new Interval(stack.peek().start, Math.max(stack.peek().end, intervals.get(i).end));
                stack.pop();
                stack.push(object);
            } else {
                stack.push(object);
            }
            //System.out.println("stack::" + stack);
        }
        //System.out.println(stack);
        while (!stack.isEmpty()) {
            //System.out.println("adding "+stack.peek());
            res.add(stack.pop());
        }
        //System.out.println(res.size());
        res.sort(intervalComparator);
        return res;
    }
}
