package Stacks;

import javafx.util.Pair;

import java.util.Stack;

public class DecryptedString {
    public static String decryptedStr(String str, int B) {
        char currChar;
        int i=0;
        long length = 0;
        String num = "";
        Stack<Pair<Character, Long>> stack = new Stack<Pair<Character, Long>>();
        while(i!=str.length()) {
            currChar = str.charAt(i);
            if(currChar >= '0' && currChar <= '9') {
                while(i < str.length() && currChar >= '0' && currChar <= '9') {
                    num = num + currChar;
                    i++;
                    if(i < str.length())
                        currChar = str.charAt(i);
                }
                System.out.println("num is "+num);
                length = length*Long.parseLong(num);
                num = "";
                if(length >= B)
                    break;
                continue;
            } else {
                length = length+1;
                Pair<Character, Long> pair = new Pair<>(currChar, length);
                stack.push(pair);
                i++;
            }
        }
        System.out.println("stack "+stack);
        long toFind = -1;
        long l;
        char ch=' ';
        if(length >= B) {
            Pair<Character, Long> tmp = stack.pop();
            System.out.println("tmp is "+tmp);
            ch = tmp.getKey();
            l = tmp.getValue();
            toFind = B % l;
            while(toFind != 0) {
                tmp = stack.pop();
                ch = tmp.getKey();
                l = tmp.getValue();
                toFind = toFind % l;
            }
            /*tmp = stack.pop();
            ch = tmp.getKey();
            l = tmp.getValue();*/
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String str = "6422328717";
        System.out.println("result is "+decryptedStr(str, 8));
    }
}
