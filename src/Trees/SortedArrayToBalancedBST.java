package Trees;

import Util.TreeNode;

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(InorderTraversal.inorderTraversal(sortedArrayToBST(arr)));
    }

    private static TreeNode sortedArrayToBST(int[] arr) {
        return helper(arr, 0, arr.length - 1);
    }

    private static TreeNode helper(int[] arr, int left, int right) {
        if (left > right) return null;
        int midpoint = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[midpoint]);
        node.left = helper(arr, left, midpoint - 1);
        node.right = helper(arr, midpoint + 1, right);
        return node;
    }
}
