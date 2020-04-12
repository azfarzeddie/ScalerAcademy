package Trees;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderIterativeTwoStack {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(postOrderIterativeTwoStack(root));
    }
    public static ArrayList<Integer> postOrderIterativeTwoStack(TreeNode node) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.isEmpty()){
            TreeNode curr = stack1.peek();
            stack2.push(curr);
            stack1.pop();
            if(curr.left!=null)
                stack1.push(curr.left);
            if(curr.right!=null)
                stack1.push(curr.right);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}
