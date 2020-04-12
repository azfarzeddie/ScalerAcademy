package LinkedList;

import Util.ListNode;

public class MiddleElement {
    public static int solve(ListNode A) {
        ListNode slowNode = A, fastNode = A;
        while(fastNode!=null&&fastNode.next!=null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(solve(head));
    }
}
