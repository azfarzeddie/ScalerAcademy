package Trees;

import Util.TreeNode;


public class LongestConsecutiveSequence {
    static int res = 1;

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left11 = new TreeNode(2);
        TreeNode left111 = new TreeNode(1);
        head1.right = right1;
        right1.left = left11;
        left11.left = left111;
        System.out.println("res initially :: " + res);
        lengthOfLongestConsecutiveSequence(head1);
        System.out.println("res :: " + res);
    }

    public static void lengthOfLongestConsecutiveSequence(TreeNode root) {
        if (root == null) return;
        helper(root, root.val, 0);
    }

    public static void helper(TreeNode root, int expectedValue, int currLength) {
        if (root == null) return;
        if (root.val == expectedValue)
            currLength++;
        else
            currLength = 1;
        res = Math.max(res, currLength);
        helper(root.left, root.val + 1, currLength);
        helper(root.right, root.val + 1, currLength);

    }
}
