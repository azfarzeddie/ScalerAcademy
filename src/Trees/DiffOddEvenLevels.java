package Trees;

import Util.TreeNode;

public class DiffOddEvenLevels {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(10);
        head1.left.left = new TreeNode(1);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(5);
        head1.right.right = new TreeNode(5);
        System.out.println(oddEvenLevelSumDiff(head1));
    }

    public static int oddEvenLevelSumDiff(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return root.val - oddEvenLevelSumDiff(root.left) - oddEvenLevelSumDiff(root.right);
    }
}
