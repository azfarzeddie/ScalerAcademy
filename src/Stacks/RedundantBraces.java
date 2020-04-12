package Stacks;

import java.util.Stack;

public class RedundantBraces {
    public static int braces(String str) {
        char currChar;
        int popcount = 0;
        int len = str.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<len;i++) {
            currChar = str.charAt(i);
            if(currChar!=')') {
                stack.push(currChar);
            } else {
                while(stack.peek() != '(') {
                    stack.pop();
                    popcount++;
                }
                if(popcount==1)
                    return 1;
                stack.pop();
                popcount = 0;
                if(!stack.empty() && stack.peek()=='(' && i<len-1 && str.charAt(i+1)==')') {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "(a+(a))";
        System.out.println("result is "+braces(str));
    }
}
