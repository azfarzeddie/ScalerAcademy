package Trees;

import Util.TreeNode;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(invertBinaryTree(root));
    }

    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = invertBinaryTree(root.left);
        TreeNode right = invertBinaryTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
