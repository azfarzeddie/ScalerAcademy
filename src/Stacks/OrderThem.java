package Stacks;

import java.util.Stack;

public class OrderThem {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 4};
        boolean sol = solve(arr);
        System.out.println("Possible - "+sol);
    }
    public static boolean solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int B_end = 0, top;
        for(int i=0;i<arr.length;i++) {
            int ele = arr[i];
            if(!stack.empty()) {
                top = stack.peek();
                while (top==B_end+1) {
                    B_end = B_end+1;
                    stack.pop();
                    if(stack.empty())
                        break;
                    top = stack.peek();
                }
                if(stack.empty()) {
                    stack.push(arr[i]);
                } else {
                    top = stack.peek();
                    if(arr[i] < top) {
                        stack.push(arr[i]);
                    } else {
                        return false;
                    }
                }
            } else {
                stack.push(ele);
            }
        }
        return false;
    }
}
