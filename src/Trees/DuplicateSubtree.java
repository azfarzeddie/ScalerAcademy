package Trees;

import Util.TreeNode;

import java.util.HashSet;

public class DuplicateSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(hasDuplicates(root));
    }

    static char MARKER = '$';

    public static int hasDuplicates(TreeNode root) {
        HashSet<String> set = new HashSet<>();
        if (hasDuplicatesUtil(root, set).equals("")) return 1;
        else return 0;
    }

    public static String hasDuplicatesUtil(TreeNode root, HashSet<String> set) {
        String s = "";
        if (root == null)
            return s + MARKER;
        System.out.println("root.val = " + root.val);
        String lstr = hasDuplicatesUtil(root.left, set);
        System.out.println("lstr = " + lstr);
        if (lstr.equals(s))
            return s;
        String rstr = hasDuplicatesUtil(root.right, set);
        System.out.println("root.val = " + root.val + " rste = " + rstr);
        if (rstr.equals(s)) {
            System.out.println("returning empty");
            return s;
        }
        s = s + root.val + lstr + rstr;
        System.out.println("s now = " + s);
        if (s.length() > 3 && set.contains(s)) {
            System.out.println("returning");
            return "";
        }
        set.add(s);
        System.out.println("set = " + set);
        return s;
    }
}
