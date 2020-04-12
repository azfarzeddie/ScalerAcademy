package Stacks;

import java.util.Stack;
import java.util.TreeMap;

import static java.lang.Integer.MIN_VALUE;

public class MaxFrequencyStack {
    static Stack<Integer> stack = new Stack<>();
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    public static int[] solve(int[][] A) {
        int row = A.length;
        int[] res = new int[row];
        int s = -1;
        int k = 0;
        for(int i=0;i<row;i++) {
            s = A[i][0];
            switch(s) {
                case 1:
                    int toInsert = A[i][1];
                    stack.push(toInsert);
                    if(map.containsKey(toInsert)) {
                        int fre = map.get(toInsert);
                        fre = fre + 1;
                        map.put(toInsert, fre);
                    } else {
                        map.put(toInsert, 1);
                    }
                    res[k++] = -1;
                    break;
                case 2:
                    int freqEle = findFrequency();
                    popEle(freqEle);
                    res[k] = freqEle;
                    k++;
                    break;
            }
        }
        return res;
    }
    public static int findFrequency() {
        Stack<Integer> tmp = (Stack<Integer>)stack.clone();
        int freq = MIN_VALUE;
        int max = MIN_VALUE;
        while(!tmp.empty()) {
            int tmpele = tmp.pop();
            if(map.get(tmpele) > max) {
                max = map.get(tmpele);
                freq = tmpele;
            }
        }
        return freq;
    }
    public static void popEle(int num) {
        Stack<Integer> tempStk = new Stack<>();
        int temp = 0;

        while(true) {
            if(!stack.empty()) {
                temp = stack.pop();
            }
            if(num != temp) {
                tempStk.push(temp);
            } else {
                map.put(num, map.get(num)-1);
                while(!tempStk.empty()) {
                    stack.push(tempStk.pop());
                }
                break;
            }

        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 46},
                {2, 0},
                {1, 11},
                {1, 38},
                {2, 0},
                {1, 71},
                {2, 0},
                {2, 0},
                {1, 45},
                {2, 0},
                {1, 27},
                {1, 23},
                {2, 0},
                {1, 69},
                {2, 0},
                {2, 0},
                {1, 76},
                {1, 64},
                {2, 0},
                {2, 0},
                {1, 13},
                {1, 13},
                {1, 93},
                {1, 90},
                {2, 0},
                {2, 0},
                {2, 0},
                {1, 4},
                {1, 63},
                {2, 0},
                {1, 9},
                {2, 0},
                {1, 26},
                {1, 29},
                {2, 0},
                {2, 0},
                {1, 26},
                {2, 0},
                {1, 91},
                {1, 52},
                {1, 89},
                {1, 8},
                {1, 95},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0},
                {1, 38},
                {2, 0},
                {2, 0},
                {1, 65}
            };
        int[] res = new int[54];
        res = solve(arr);
        for (int i=0;i<53;i++) {
            System.out.print(res[i]+" ");
        }
    }
}
