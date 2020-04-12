package Trees;

import Util.TreeNode;

import java.util.Stack;

public class EqualTreePartition {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(isEqualPartitionPossible(root));
    }

    static Stack<Integer> stack;

    public static boolean isEqualPartitionPossible(TreeNode root) {
        stack = new Stack<>();
        int sum = sum(root);
        stack.pop();
        if (sum % 2 == 0)
            for (int s : stack)
                if (s == sum / 2)
                    return true;
        return false;
    }

    public static int sum(TreeNode root) {
        if (root == null) return 0;
        stack.push(sum(root.left) + sum(root.right) + root.val);
        return stack.peek();
    }
}
