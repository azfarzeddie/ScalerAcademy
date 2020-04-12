package Sorting;

import java.util.*;

public class Inversions {
    public static int swapCount = 0;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.println(inversions(list));
    }

    public static int inversions(ArrayList<Integer> arr) {
        Collections.sort(arr, new InvComparator());
        return swapCount;
    }
}

class InvComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        Map<Integer, Integer> map = new HashMap<>();
        if(a>b) {
            System.out.println(a+" is greater than "+b);
            if(!map.containsKey(a)) {
                System.out.println("map does not contain a "+a);
                map.put(a, b);
                Inversions.swapCount++;
            }
            return 1;
        }
        else if(a<b) {
            System.out.println(a+" is less than "+b);
            if(!map.containsKey(a)) {
                System.out.println("map does not contain a "+a);
                map.put(b, a);
                Inversions.swapCount++;
            }
            return -1;
        }
        else
            return 0;
    }
}
