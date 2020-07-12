package Backtracking;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {
    static ArrayList<String> res = new ArrayList<>();

    public static void main (String[] args) {
        int A = 3;
        System.out.println("Parentheses :: " + generateParenthesis(A));
    }

    public static ArrayList<String> generateParenthesis (int A) {
        if (A > 0)
            parenthesesUtil(A, 1, 0, new StringBuilder("("));
        return res;
    }

    public static void parenthesesUtil (int A, int open, int close, StringBuilder str) {
        if (close == A) {
            res.add(str.toString());
            return;
        } else {
            if (open < A) {
                str.append("(");
                parenthesesUtil(A, open + 1, close, str);
                str.deleteCharAt(str.length() - 1);
            }
            if (close < open) {
                str.append(")");
                parenthesesUtil(A, open, close + 1, str);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
