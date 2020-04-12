package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        int A = 1;
        int B = 1;
        System.out.println("LCA is " + lca(root, A, B));
    }

    public static int lca(TreeNode root, int A, int B) {
        // find the path from root to A and from root to B
        // iterate over the two paths and return the element just before the first dissimilar elements
        ArrayList<Integer> pathA = new ArrayList<>();
        pathA = findPath(root, A, pathA);
        ArrayList<Integer> pathB = new ArrayList<>();
        pathB = findPath(root, B, pathB);
        System.out.println("lengths are " + pathA.size() + " " + pathB.size());
        int i = 0;
        if (pathA.size() > 1 && pathB.size() > 1) {
            for (i = 0; i < Math.min(pathA.size(), pathB.size()); i++) {
                if (!pathA.get(i).equals(pathB.get(i)))
                    break;
            }
            return pathA.get(i - 1);
        } else {
            if (pathA.get(0).equals(pathB.get(0)))
                return pathA.get(0);
        }
        return -1;
    }

    public static ArrayList<Integer> findPath(TreeNode root, int X, ArrayList<Integer> path) {
        if (root == null) return new ArrayList<>();
        path.add(root.val);
        if (root.val == X)
            return path;
        if (root.left != null && findPath(root.left, X, path).size() > 0)
            return path;
        if (root.right != null && findPath(root.right, X, path).size() > 0)
            return path;
        path.remove(path.size() - 1);
        return new ArrayList<>();
    }
}
