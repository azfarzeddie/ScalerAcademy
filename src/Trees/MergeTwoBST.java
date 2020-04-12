package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class MergeTwoBST {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(8);
        TreeNode head2 = new TreeNode(7);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(9);
        head1.left = left1;
        head1.right = right1;
        head2.left = left2;
        head2.right = right2;
        System.out.println(merge(head1, head2));
    }

    //public static ArrayList<Integer> mergeTwoBST(TreeNode A, TreeNode B) {
    static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
        return res;
    }

    public static ArrayList<Integer> merge(TreeNode head1, TreeNode head2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1 = inorder(head1, list1);
        System.out.println("inorder of tree1 :: "+list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2 = inorder(head2, list2);
        System.out.println("inorder of tree2 :: "+list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3 = mergeLists(list1, list2, list3);
        return list3;
    }

    private static ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }
        while (i < list1.size())
            list3.add(list1.get(i++));
        while (j < list2.size())
            list3.add(list2.get(j++));
        return list3;
    }
}
