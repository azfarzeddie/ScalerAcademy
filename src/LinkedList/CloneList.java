package LinkedList;

import Util.ListNodeRandom;
import Util.ScalerUtils;

public class CloneList {
    static ScalerUtils utils = new ScalerUtils();
    public static ListNodeRandom cloneList(ListNodeRandom a) {
        ListNodeRandom temp = a;
        ListNodeRandom aone = a;
        while (a != null) {
            ListNodeRandom newNode = new ListNodeRandom(a.val);
            newNode.next = a.next;
            a.next = newNode;
            a = a.next.next;
        }
        while(aone != null) {
            aone.next.random = aone.random.next;
            aone = aone.next.next;
        }
        ListNodeRandom origin = temp;
        ListNodeRandom clone = temp.next;
        ListNodeRandom res = clone;
        temp = clone;
        while(origin!=null && clone!=null && origin.next!=null && clone.next!=null) {
            origin.next = origin.next.next;
            origin = origin.next;
            clone.next = clone.next.next;
            clone = clone.next;
        }
        //utils.printLinkedListRandom( temp );
        return res;
    }

    public static void main(String[] args) {
        ListNodeRandom head = new ListNodeRandom(1);
        ListNodeRandom node1 = new ListNodeRandom(2);
        ListNodeRandom node2 = new ListNodeRandom(3);
        ListNodeRandom node3 = new ListNodeRandom(4);
        ListNodeRandom node4 = new ListNodeRandom(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head.random = node2;
        node1.random = node3;
        node2.random = head;
        node3.random = node4;
        node4.random = node1;
        System.out.println("Calling");
        System.out.println(cloneList( head ).val);
    }
}
