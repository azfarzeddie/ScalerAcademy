package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class KthSmallestElementBST {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(2);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(3);
        head1.left = left1;
        head1.right = right1;
        int k = 2;
        System.out.println(kthSmallestElementBST(head1, k));
    }

    public static int kthSmallestElementBST(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder = inorderTraversal(root, inorder);
        return inorder.get(k-1);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if(root!=null) {
            inorderTraversal(root.left, inorder);
            inorder.add(root.val);
            inorderTraversal(root.right, inorder);
        }
        return inorder;
    }
}
