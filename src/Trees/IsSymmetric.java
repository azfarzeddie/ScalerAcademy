package Trees;

import Util.TreeNode;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public static int isSymmetric(TreeNode root) {
        return util(root, root)?1:0;
    }

    public static boolean util(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return true;
        if(root1.val==root2.val)
            return util(root1.left, root2.right)&&util(root1.right, root2.left);
        return false;
    }
}
