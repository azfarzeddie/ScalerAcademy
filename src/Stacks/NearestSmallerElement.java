package Stacks;

import java.util.Stack;

public class NearestSmallerElement {
    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) {
            if(stack.empty()) {
                stack.push(i);
                continue;
            }
            if (arr[i] >= arr[stack.peek()]) {
                stack.push(i);
            }
            else {
                while(!stack.empty() && arr[i] < arr[stack.peek()]) {
                    int index = stack.pop();
                    left[index] = arr[i];
                }
                stack.push(i);
            }
        }
        while(!stack.empty()) {
            left[stack.pop()] = -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 8};
        System.out.println("Result is ");
        int[] res = prevSmaller(A);
        for(int i=0;i<res.length;i++) {
            System.out.print(res[i]+" ");
        }
    }
}
