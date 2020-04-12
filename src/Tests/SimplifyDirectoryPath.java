package Tests;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public static String simplify(String str) {
        String res = "/";
        Stack<String> stack = new Stack<>();
        int len = str.length();
        for(int i=0;i<len;i++) {
            while (i < len && str.charAt(i) == '/') {
                i++;
            }
            String dir = "";
            while (i < len && str.charAt(i) != '/') {
                dir += str.charAt(i);
                i++;
            }
            if (dir.equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else if (dir.equals(".")) {
                continue;
            } else if (dir.length() != 0) {
                stack.push(dir);
            }
        }
        Stack<String> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        while (!temp.empty()) {
            if (temp.size() != 1) {
                res = res + temp.pop() + "/";
            } else {
                res = res + temp.pop();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String str = "/../";
        System.out.println("res = " + simplify(str));
    }
}
