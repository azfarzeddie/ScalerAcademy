package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

import java.util.HashMap;

public class RemoveNthFromEnd {
    static ScalerUtils utils = new ScalerUtils();
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = A;
        int count = 1;
        while(temp!=null) {
            map.put(count++,temp);
            temp = temp.next;
        }
        int c = map.size();
        B = Math.min(B,c);
        ListNode prev = map.get(c-B);
        ListNode next = map.get(c-B+2);
        if(prev==null)
            return next;
        prev.next = next;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(head.val);
        utils.printLinkedList(removeNthFromEnd(head, 2));
    }
}
