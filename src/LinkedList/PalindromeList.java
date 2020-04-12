package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

public class PalindromeList {
    static ScalerUtils utils = new ScalerUtils();
    static ListNode slownode, fastnode, secondhalf;

    public static int lpalin(ListNode a) {
        /*
         * 1 - find middle node
         * 2 - if size is even, fastnode will be null
         * 3 - if size is odd, fastnode will point to last node
         * 4 - if size is odd, maintain a midnode pointer to store the middle element. this element should not be reversed
         * 5 - reverse the second half of the list
         * 6 - compare if first half and second half are same or not
         * 7 - if same, return 1 else 0
         */
        slownode = a;
        fastnode = a;
        ListNode prevofslow = a, midnode;
        while (fastnode != null && fastnode.next != null) {
            prevofslow = slownode;
            slownode = slownode.next;
            fastnode = fastnode.next.next;
        }
        if (fastnode != null) {
            midnode = slownode;
            slownode = slownode.next;
        }
        secondhalf = slownode;
        prevofslow = null;
        reverse();
        int res = comparelists(a, secondhalf);
        return res;

    }

    private static int comparelists(ListNode a, ListNode secondhalf) {
        ListNode temp1 = a, temp2 = secondhalf;
        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val)
                return 0;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return 1;
    }

    private static void reverse() {
        ListNode prev = null;
        ListNode curr = secondhalf;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondhalf = prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(lpalin(head));
    }
}
