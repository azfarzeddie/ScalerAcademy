package Heaps;

import Util.ListNode;
import Util.ScalerUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main (String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(10);
        root1.next.next = new ListNode(20);
        ListNode root2 = new ListNode(4);
        root2.next = new ListNode(11);
        root2.next.next = new ListNode(13);
        ListNode root3 = new ListNode(3);
        root3.next = new ListNode(8);
        root3.next.next = new ListNode(9);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(root1);
        list.add(root2);
        list.add(root3);
        System.out.println("Combined Linked List :: " + MergeKLists(list).val);
    }

    public static ListNode MergeKLists (ArrayList<ListNode> list) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare (ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            ListNode temp = list.get(i);
            while (temp != null) {
                minHeap.add(temp);
                temp = temp.next;
            }
        }

        ListNode head = minHeap.poll();
        ListNode finalNode = head;
        while (! minHeap.isEmpty()) {
            ListNode newNode = new ListNode(minHeap.peek().val);
            minHeap.poll();
            newNode.next = null;
            head.next = newNode;
            head = head.next;
            ScalerUtils scalerUtils = new ScalerUtils();
            scalerUtils.printLinkedList(finalNode);
        }

        return finalNode;
    }

}
