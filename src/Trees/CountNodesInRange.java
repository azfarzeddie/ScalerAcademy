package Trees;

import Util.TreeNode;

public class CountNodesInRange {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        TreeNode left1 = new TreeNode(8);
        /*TreeNode right1 = new TreeNode(8);
        TreeNode right11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(15);
        TreeNode left121 = new TreeNode(7);*/
        head1.left = left1;
        /*head1.right = right1;
        left1.right = right11;
        right1.right = right12;
        right12.left = left121;*/
        int start = 12;
        int end = 20;
        System.out.println(countNodesInRange(head1, start, end));
    }
    static int count = 0;

    private static int countNodesInRange(TreeNode root, int start, int end) {
        inorder(root, start, end);
        return count;
    }

    private static void inorder(TreeNode root, int start, int end) {
        if (root != null) {
            //System.out.println("root :: " + root.val + " start :: " + start + " end :: " + end);
            inorder(root.left, start, end);
            if (root.val >= start && root.val <= end)
                count++;
            inorder(root.right, start, end);
        }
    }

}
