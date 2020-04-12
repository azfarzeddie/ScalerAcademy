package Trees;

import Util.TreeNode;

public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        System.out.println(sumRootToLeafNumbers(root));
    }

    public static int sumRootToLeafNumbers(TreeNode root) {
        int sum = 0;
        sum = returnSumRootToLeaf(root, sum, "");
        return sum;
    }

    public static int returnSumRootToLeaf(TreeNode root, int sum, String str) {
        //System.out.println("root = " + root.val);
        if (root == null) return sum;
        str = str.concat(String.valueOf(root.val));
        System.out.println("str = " + str);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(str);
        }
        sum = returnSumRootToLeaf(root.left, sum, str);
        sum = returnSumRootToLeaf(root.right, sum, str);
        return sum;
    }
}
