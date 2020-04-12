package Trees;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeFromPostorder {
    public static void main(String[] args) {
        Integer[] post = {2, 3, 1};
        Integer[] in = {2, 1, 3};
        ArrayList<Integer> postList = new ArrayList<>(Arrays.asList(post));
        ArrayList<Integer> inList = new ArrayList<>(Arrays.asList(in));
        System.out.println(buildTree(inList, postList).val);
    }

    public static TreeNode buildTree(ArrayList<Integer> in, ArrayList<Integer> post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.size(); i++) {
            map.put(in.get(i), i);
        }
        System.out.println("map : " + map);
        return treeFromTraversals(map, in, post, post.size() - 1, 0, in.size() - 1);
    }

    public static TreeNode treeFromTraversals(Map map, ArrayList<Integer> in, ArrayList<Integer> post, int postS, int inS, int inE) {
        System.out.println("ins=" + inS + " ine=" + inE + " posts=" + postS);
        if (postS < 0 || inS > inE) return null;
        TreeNode root = new TreeNode(post.get(postS));
        int index = (int) map.get(root.val);
        root.left = treeFromTraversals(map, in, post, postS - 1 + index - inE, inS, index - 1);
        root.right = treeFromTraversals(map, in, post, postS - 1, index + 1, inE);
        return root;
    }
}
