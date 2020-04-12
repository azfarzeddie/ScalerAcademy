package Trees;

import Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeFromTraversals {
    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] in = {2, 1, 3};
        System.out.println(buildTree(in, pre).val);
    }

    public static TreeNode buildTree(int[] in, int[] pre) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        System.out.println("map : " + map);
        return treeFromTraversals(map, in, pre, 0, 0, in.length - 1);
    }

    public static TreeNode treeFromTraversals(Map map, int[] in, int[] pre, int preS, int inS, int inE) {
        System.out.println("ins=" + inS + " ine=" + inE + " pres=" + preS);
        if (preS > pre.length - 1 || inS > inE) return null;
        TreeNode root = new TreeNode(pre[preS]);
        int index = (int) map.get(root.val);
        System.out.println("index = "+index);
        root.left = treeFromTraversals(map, in, pre, preS + 1, inS, index - 1);
        root.right = treeFromTraversals(map, in, pre, preS + index - inS + 1, index + 1, inE);
        return root;
    }
}
