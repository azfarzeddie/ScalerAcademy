package Stacks;

import java.util.Stack;

public class RectangleHistogram {
    public static int largestArea(int[] arr) {
        int[] right = new int[arr.length];
        int[] left =  new int[arr.length];
        int min = Integer.MAX_VALUE;
        int minindex = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<arr.length;i++) {
            if(arr[i]<min) {
                minindex = i;
                min = arr[i];
            }
            if(stack.empty()) {
                stack.push(i);
                continue;
            }
            if (arr[i] >= arr[stack.peek()]) {
                System.out.println("next element "+arr[i]+" is greater than top of stack element "+arr[stack.peek()]+". Pushing into stack");
                stack.push(i);
            }
            else {
                while(!stack.empty() && arr[i] < arr[stack.peek()]) {
                    System.out.println("next element " + arr[i] + " is less than top od stack element "+arr[stack.peek()]+". Popping");
                    int index = stack.pop();
                    System.out.println("stack is "+stack);
                    right[index] = i;
                    System.out.println("Right Array is : ");
                    printArray(right);
                }
                stack.push(i);
            }
        }
        System.out.println("Value of min is "+min+" and minindex is "+minindex);
        while(!stack.empty()) {
            right[stack.pop()] = -1;
        }
        System.out.println("Right Array is : ");
        printArray(right);

        for (int i=arr.length - 1;i>=0;i--) {
            if(stack.empty()) {
                stack.push(i);
                continue;
            }
            if (arr[i] >= arr[stack.peek()]) {
                System.out.println("next element " + arr[i] + " is greater than top of stack element "+arr[stack.peek()]+". Pushing into stack");
                stack.push(i);
            }
            else {
                while(!stack.empty() && arr[i] < arr[stack.peek()]) {
                    System.out.println("next element " + arr[i] + " is less than top od stack element"+arr[stack.peek()]+". Popping");
                    int index = stack.pop();
                    left[index] = i;
                    System.out.println("Left Array is : ");
                    printArray(left);
                }
                stack.push(i);
            }
        }
        while(!stack.empty()) {
            left[stack.pop()] = -1;
        }
        System.out.println("Left Array is : ");
        printArray(left);
        for(int k=0;k<right.length;k++) {
            if(right[k]==-1)
                right[k]=arr.length;
            if(left[k]==-1)
                left[k]=-1;
        }
        System.out.println("Final Right Array is : ");
        printArray(right);
        System.out.println("Final Left Array is : ");
        printArray(left);

        int maxArea = 0;
        int currArea = 0;
        for(int k=0;k<arr.length;k++) {
            currArea = arr[k]*(Math.abs(left[k]-right[k])-1);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;

    }

    public static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
        System.out.println("Area is "+largestArea(arr));
    }
}
