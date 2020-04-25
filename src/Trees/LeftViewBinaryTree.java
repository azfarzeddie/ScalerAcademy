package Trees;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class LeftViewBinaryTree {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
        head1.left.left = new TreeNode(4);
        head1.right.left = new TreeNode(5);
        head1.right.right = new TreeNode(6);
        head1.right.left.left = new TreeNode(8);
        head1.right.left.right = new TreeNode(9);
        head1.right.left.right.right = new TreeNode(10);
        leftView(head1, 0);
        System.out.println(list);

    }

    static HashMap<Integer, Boolean> map = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void leftView(TreeNode root, int level) {
        if (root == null) return;
        if (!map.containsKey(level))
            map.put(level, false);
        if (map.containsKey(level) && !map.get(level)) {
            list.add(root.val);
            map.put(level, true);
        }
        if (root.left != null)
            leftView(root.left, level + 1);
        if (root.right != null)
            leftView(root.right, level + 1);
        return;
    }
}
