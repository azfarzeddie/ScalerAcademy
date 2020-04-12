package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class RootToLeafPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(2000);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(-3001);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        int sum = -1;
        System.out.println(pathToLeafSum(root, sum));
    }

    public static ArrayList<ArrayList<Integer>> pathToLeafSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        paths(root, sum, paths, new ArrayList<>());
        return paths;
    }

    public static void paths(TreeNode root, int sum, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            paths.add(new ArrayList<>(path));
        } else {
            int k = sum - root.val;
            paths(root.left, k, paths, path);
            paths(root.right, k, paths, path);
        }
        path.remove(path.size() - 1);
    }
}
