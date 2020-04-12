package Stacks;

import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String solve(String str) {
        HashSet<Character> set = new HashSet<>();
        Stack<Character> stk = new Stack<>();
        int len = str.length();
        boolean isPresentAtEnd = false;
        char currChar;
        for(int i=0;i<len;i++) {
            currChar = str.charAt(i);
            System.out.println("Current character = "+currChar);
            if(stk.empty()) {
                System.out.println("Stack is empty. Inserting "+currChar);
                stk.push(currChar);
                set.add(currChar);
                System.out.println("Stack = "+stk);
                continue;
            }
            if(set.contains(currChar)) {
                // We need not add this element into the stack since it would be in stack
                System.out.println("Set already contains "+currChar+". Continue.");
                continue;
            } else {
                if(!stk.empty() && (int)currChar < (int)stk.peek()) {
                    while(!stk.isEmpty() && (int)currChar<(int)stk.peek()) {
                        isPresentAtEnd = checkCharFromRight(stk.peek(), str, i);
                        if (isPresentAtEnd == true) {
                            System.out.println(stk.peek() + " is also present beyond index " + i + ". Removing it from stack.");
                            set.remove(stk.pop());
                            System.out.println("Stack = " + stk);
                        }
                        if (isPresentAtEnd == false) {
                            break;
                        }
                    }
                    System.out.println(currChar+" is smaller than stack top element ");
                    System.out.println("Adding " + currChar + " to stack.");
                    set.add(currChar);
                    stk.push(currChar);
                    System.out.println("Stack = " + stk);
                } else if((int)currChar > (int)stk.peek()) {
                    System.out.println(currChar+" is bigger than stack top element "+stk.peek()+". Inserting into stack.");
                    stk.push(currChar);
                    set.add(currChar);
                    System.out.println("Stack = "+stk);
                }
            }
        }
        System.out.println("Stack = "+stk);
        String res = "";
        int size = stk.size();
        for(int i=0;i<size;i++) {
            res = stk.pop() + res;
        }
        return res;
    }

    public static boolean checkCharFromRight(char ch, String str, int pos) {
        for(int i=str.length()-1;i>pos;i--) {
            if(str.charAt(i) == ch)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "oxvoopx";
        System.out.println("Res = "+solve(str));
    }
}
