package Trees;

import Util.TreeNodeNext;

public class PopulateNextRightPointers {
    public static void main(String[] args) {
        TreeNodeNext head = new TreeNodeNext(1);
        head.left = new TreeNodeNext(2);
        head.right = new TreeNodeNext(3);
        head.left.left = new TreeNodeNext(4);
        head.left.right = new TreeNodeNext(5);
        head.right.left = new TreeNodeNext(6);
        head.right.right = new TreeNodeNext(7);
        connect(head);
    }

    public static void connect(TreeNodeNext root) {
        if (root == null) return;
        if (root.next != null) connect(root.next);
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
                root.right.next = getNextRight(root);
            } else {
                root.left.next = getNextRight(root);
            }
            connect(root.left);
        } else if (root.right != null) {
            root.right.next = getNextRight(root);
            connect(root.right);
        } else {
            connect(getNextRight(root));
        }
    }

    private static TreeNodeNext getNextRight(TreeNodeNext root) {
        TreeNodeNext node = root.next;
        while (node != null) {
            if (node.left != null)
                return node.left;
            if (node.right != null)
                return node.right;
            node = node.next;
        }
        return null;
    }


}
