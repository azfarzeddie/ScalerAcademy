package Stacks;

import java.util.Stack;

public class EvaluatePostfix {
    public static int evaluatePostfix(String[] A) {
        String currEle = "";
        String operator = "";
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) {
            currEle = A[i];
            if(currEle!="+" && currEle!="-" && currEle!="*" && currEle!="/") {
                stack.push(Integer.parseInt(currEle));
            } else {
                operator = currEle;
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                switch (operator) {
                    case "+":
                        stack.push(leftOperand+rightOperand);
                        break;
                    case "-":
                        stack.push(leftOperand-rightOperand);
                        break;
                    case "*":
                        stack.push(leftOperand*rightOperand);
                        break;
                    case "/":
                        stack.push(leftOperand/rightOperand);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "2", "/"};
        System.out.println("Result is "+evaluatePostfix(arr));
    }
}
