package Trees;

import Util.TreeNode;

import java.util.ArrayList;

public class CommonNodesInBST {
    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(8);
        TreeNode right11 = new TreeNode(3);
        TreeNode right12 = new TreeNode(15);
        TreeNode left121 = new TreeNode(7);
        TreeNode head2 = new TreeNode(7);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(10);
        TreeNode right21 = new TreeNode(2);
        TreeNode right22 = new TreeNode(15);
        TreeNode right221 = new TreeNode(8);
        head1.left = left1;
        head1.right = right1;
        left1.right = right11;
        right1.right = right12;
        right12.left = left121;
        head2.left = left2;
        head2.right = right2;
        left2.right = right21;
        right2.right = right22;
        right22.left = right221;
        System.out.println(commonNodeInBST(head1, head2));
    }

    private static int commonNodeInBST(TreeNode head1, TreeNode head2) {
        ArrayList<Integer> list1;
        ArrayList<Integer> list2;
        ArrayList<Integer> util = new ArrayList<>();
        list1 = inorderTraversal(head1, util);
        util = new ArrayList<>();
        list2 = inorderTraversal(head2, util);
        int sum = 0;
        //System.out.println("size 1 :: " + list1.size() + " size 2 :: " + list2.size());
        for (int i = 0; i < (Math.max(list1.size(), list2.size())); i++) {
            if (i < list1.size() && list2.contains(list1.get(i)))
                sum += list1.get(i);
            if (i < list2.size() && list1.contains(list2.get(i)))
                sum += list2.get(i);
        }
        return sum/2;
    }

    private static ArrayList<Integer> inorderTraversal(TreeNode head1, ArrayList<Integer> list) {

        if (head1 != null) {
            inorderTraversal(head1.left, list);
            list.add(head1.val);
            inorderTraversal(head1.right, list);
        }
        return list;
    }
}
