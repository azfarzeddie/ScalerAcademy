package Stacks;

import java.util.Stack;

public class ReverseStackRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] res = solve(arr);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]+" ");
        }
    }
    static Stack<Integer> stack = new Stack<>();
    public static int[] solve(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            stack.push(arr[i]);
        }
        reverse();
        for(int i=0;i<arr.length;i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
    public static void reverse() {
        if(stack.size() > 0) {
            int ele = stack.peek();
            stack.pop();
            reverse();
            stack.push(ele);
        }
    }
}
