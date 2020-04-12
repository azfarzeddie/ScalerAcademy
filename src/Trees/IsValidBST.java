package Trees;

import Util.TreeNode;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    public static int isValidBST(TreeNode root) {
        boolean res = false;
        res = checkUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res?1:0;
    }

    public static boolean checkUtil(TreeNode root, int min, int max) {
        if (root==null)return true;
        if(root.val>max||root.val<min)return false;
        boolean l = checkUtil(root.left, min, root.val-1);
        boolean r = checkUtil(root.right, root.val+1, max);
        return l&&r;
    }
}
