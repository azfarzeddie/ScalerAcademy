package Trees;

import Util.TreeNode;

public class HeightBalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;
        System.out.println(isHeightBalanced(root));
    }

    public static int isHeightBalanced(TreeNode root) {
        return helper(root).balanced ? 1 : 0;
    }

    static class pair {
        boolean balanced;
        int height;

        pair(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public static pair helper(TreeNode root) {
        if (root == null) return new pair(-1, true);
        pair lp = helper(root.left);
        pair rp = helper(root.right);
        pair sp = new pair(Math.max(lp.height, rp.height) + 1,
                lp.balanced && rp.balanced && Math.abs(lp.height - rp.height) <= 1);
        return sp;
    }
}
