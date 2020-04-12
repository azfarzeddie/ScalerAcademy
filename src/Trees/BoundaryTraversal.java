package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode tree;
        tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(14);
        tree.right = new TreeNode(22);
        tree.right.right = new TreeNode(25);
        list = boundaryTraversal(tree);
        System.out.println(list);
    }

    public static ArrayList<Integer> boundaryTraversal(TreeNode root) {
        if (root == null) return null;
        list.add(root.val);
        boundaryLeft(root.left);
        boundaryLeaf(root);
        boundaryRight(root.right);
        return list;
    }

    private static void boundaryRight(TreeNode root) {
        if (root == null) return;
        if(root.left==null&&root.right==null)return;
        if (root.right != null) {
            boundaryRight(root.right);
        } else if (root.left != null) {
            boundaryRight(root.left);
        }
        list.add(root.val);
    }

    private static void boundaryLeaf(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        boundaryLeaf(root.left);
        boundaryLeaf(root.right);
    }

    private static void boundaryLeft(TreeNode root) {
        if (root == null) return;
        if(root.left==null && root.right==null)return;
        if (root.left != null) {
            list.add(root.val);
            boundaryLeft(root.left);
        } else if (root.right != null) {
            list.add(root.val);
            boundaryLeft(root.right);
        }
    }
}
