package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

public class RemoveDuplicates {
    static ScalerUtils scalerUtils = new ScalerUtils();

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //System.out.println(head.val);
        scalerUtils.printLinkedList(head);
        scalerUtils.printLinkedList(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int temp = current.next.val;
                while (current.next != null && current.next.val == temp) {
                    // jump over all duplicates
                    current.next = current.next.next;
                }
            }else {
                current = current.next;
            }
            // check to avoid null.next error
            if (current.next == null){
                return dummy.next;
            }
        }
        return dummy.next;
    }
}
