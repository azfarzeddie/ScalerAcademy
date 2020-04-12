package Queues;

import Util.ScalerUtils;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingCharacter {
    ScalerUtils utils = new ScalerUtils();
    public static String solve(String A) {
        StringBuilder builder = new StringBuilder();
        int[] count = new int[26];
        Queue<Character> deque = new LinkedList<>();
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            deque.add(ch);
            count[ch - 'a']+=1;
            while(!deque.isEmpty()) {
                if(count[deque.peek() - 'a']>1)
                    deque.remove();
                else {
                    builder.append(deque.peek());
                    break;
                }
            }
            if(deque.isEmpty()) {
                builder.append("#");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "abadbc";
        System.out.println(solve(str));
    }
}
