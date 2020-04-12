package Trees;

import Util.TreeNode;

public class LargestBSTSubtree {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(15);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(8);
        TreeNode right3 = new TreeNode(7);
        head1.left = left1;
        head1.right = right1;
        left1.left = left2;
        left1.right = right2;
        right1.right = right3;
        System.out.println(largestBSTSubtree(head1));
    }

    public static int largestBSTSubtree(TreeNode root) {
        if (isBST(root) == true) {
            return size(root);
        } else {
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }

    private static int size(TreeNode root) {
        if (root == null)
            return 0;
        return size(root.left) + 1 + size(root.right);
    }

    public static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean isBSTUtil(TreeNode root, int maxValue, int minValue) {
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue)
            return false;
        return isBSTUtil(root.left, root.val - 1, minValue) && isBSTUtil(root.right, maxValue, root.val + 1);
    }


}
