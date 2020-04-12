package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null)
            return B;
        else if (B == null)
            return A;

        if (A.val < B.val)
            return mergeUtil(A, B);
        else
            return mergeUtil(B, A);
    }

    private static ListNode mergeUtil(ListNode a, ListNode b) {
        System.out.println("mergeUtil called with " + b.val + " " + a.val);
        if (a.next == null) {
            a.next = b;
            return a;
        }
        ListNode curr1 = a, next1 = a.next;
        ListNode curr2 = b, next2 = b.next;
        while (next1 != null && curr2 != null) {
            if (curr2.val >= curr1.val && curr2.val <= next1.val) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;

                curr1 = curr2;
                curr2 = next2;
            } else {
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                } else {
                    next1.next = curr2;
                    return a;
                }
            }
        }
        return a;
    }

    static ScalerUtils utils = new ScalerUtils();

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // 1->3->5 LinkedList created

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        // 0->2->4 LinkedList created

        ListNode mergedhead = mergeTwoLists(head1, head2);
        utils.printLinkedList(mergedhead);

    }

}
