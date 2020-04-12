package LinkedList;

import Util.ListNode;

public class IntersectionOfLists {
    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a == null || b == null)
            return null;
        int lena = 0, lenb = 0;
        ListNode tempa = a, tempb = b;
        while (a.next != null) {
            a = a.next;
            lena++;
        }
        while (b.next != null) {
            b = b.next;
            lenb++;
        }
        System.out.println("length of a is "+lena+" length of b is "+lenb);
        for (int i = 0; i < Math.abs(lena - lenb); i++) {
            System.out.println("running loop for "+Math.abs(lena - lenb)+" times");
            if (lena > lenb) {
                System.out.println("incrementing ptr of a");
                tempa = tempa.next;
            }
            else if (lenb > lena)
                tempb = tempb.next;
        }
        System.out.println("tempa.val = "+tempa.val+" tempb.val = "+tempb.val);
        while (tempa != null) {
            System.out.println("in while");
            if (tempa == tempb ) {
                return tempa;
            }
            tempa = tempa.next;
            tempb = tempb.next;
            System.out.println("WHILE tempa.val = "+tempa.val+" tempb.val = "+tempb.val);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(56);
        ListNode node1 = new ListNode(79);
        ListNode node2 = new ListNode(78);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(97);
        ListNode node5 = new ListNode(64);
        ListNode node6 = new ListNode(47);
        ListNode node7 = new ListNode(10);
        ListNode head2 = new ListNode(97);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(46);
        ListNode node10 = new ListNode(83);
        ListNode node11 = new ListNode(54);
        ListNode node12 = new ListNode(47);
        ListNode node13 = new ListNode(24);
        ListNode node14 = new ListNode(81);
        ListNode node15 = new ListNode(85);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node14;
        node14.next = node15;
        head2.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        System.out.println("Calling");
        System.out.println(getIntersectionNode(head1, head2).val);
    }
}