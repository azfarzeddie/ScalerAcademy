package Trees;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(postOrderTraversal(root));
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();
        if (node == null)
            return list;
        S.push(node);
        TreeNode prev = null;
        while (!S.isEmpty()) {
            TreeNode current = S.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    list.add(current.val);
                }
            } else if (current.right == prev) {
                S.pop();
                list.add(current.val);
            }

            prev = current;
        }

        return list;
    }
}
