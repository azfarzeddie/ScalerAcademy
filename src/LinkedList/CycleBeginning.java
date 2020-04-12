package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

public class CycleBeginning {
    static ScalerUtils utils = new ScalerUtils();
    public static ListNode detectCycle(ListNode A) {
        // detect whether a cycle is present
        ListNode slowPtr = A, fastPtr = A;
        boolean cyclefound = false;
        while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr==fastPtr) {
                cyclefound = true;
                System.out.println("Cycle found");
                break;
            }
        }
        // count length of the cycle
        int count = 0;
        if(cyclefound) {
            while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                count++;
                if (slowPtr == fastPtr) {
                    System.out.println("Loop found at "+slowPtr.val);
                    break;
                }
            }
            // find start of cycle
            ListNode ptr1 = A, ptr2 = A;
            int loopCount = count;
            System.out.println("Loop count is "+loopCount);
            while (loopCount != 0) {
                ptr2 = ptr2.next;
                loopCount--;
            }
            System.out.println("ptr1 "+ptr1.val);
            System.out.println("ptr2 "+ptr2.val);
            if(ptr1==ptr2)
                return ptr1;
            while (ptr1 != ptr2) {
                System.out.println("ptr1 is "+ptr1.val);
                System.out.println("ptr2 is "+ptr2.val);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                if (ptr1 == ptr2) {
                    System.out.println("Returning "+ptr1.val);
                    return ptr1;
                }
            }
        }
        return null;
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
        node4.next = head;
        System.out.println("Calling");
        System.out.println((detectCycle(head)).val);
    }

}
