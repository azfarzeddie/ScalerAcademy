package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        Integer[] arr = {0, 0, 0, 0, 0};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println("number is " + largestNumber(list));
    }

    public static String largestNumber(ArrayList<Integer> arr) {
        Collections.sort(arr, new DigitSort());
        StringBuilder str = new StringBuilder();
        for (int i=arr.size()-1;i>=0;i--) {
            str.append(arr.get(i));
        }

        if(countZero(str.toString())==str.toString().length())
            return "0";
        return str.toString();
    }

    public static int countZero(String str) {
        int count = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='0')
                count++;
        }
        return count;
    }
}

class DigitSort implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String o1str = String.valueOf(o1);
        String o2str = String.valueOf(o2);
        StringBuilder res1 = new StringBuilder();
        res1.append(o1str);
        res1.append(o2str);
        StringBuilder res2 = new StringBuilder();
        res2.append(o2str);
        res2.append(o1str);
        if(res1.toString().compareTo(res2.toString())>0)
            return 1;
        else if (res1.toString().compareTo(res2.toString())<0)
            return -1;
        else
            return 0;
    }
}
