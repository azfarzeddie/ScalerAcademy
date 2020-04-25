package Trees;

import Util.TreeNode;

public class ChildrenSumPropertyTree {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(10);
        head1.left.left = new TreeNode(1);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(5);
        head1.right.right = new TreeNode(5);
        System.out.println(childrenSum(head1));
    }

    public static TreeNode childrenSum(TreeNode root) {
        int leftval = 0, rightval = 0;
        if (root == null || (root.left == null && root.right == null)) return root;
        childrenSum(root.left);
        childrenSum(root.right);
        if (root.left != null)
            leftval = root.left.val;
        if (root.right != null)
            rightval = root.right.val;
        int diff = leftval + rightval - root.val;
        if (diff > 0)
            root.val = root.val + diff;
        else if (diff < 0)
            increment(root, -diff);
        return root;
    }

    static void increment(TreeNode node, int diff) {
        if (node.left != null) {
            node.left.val = node.left.val + diff;
            increment(node.left, diff);
        } else if (node.right != null) {
            node.right.val = node.right.val + diff;
            increment(node.right, diff);
        }
    }
}
