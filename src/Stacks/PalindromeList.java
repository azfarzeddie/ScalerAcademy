package Stacks;

public class PalindromeList {
    static ListNode head, slow_ptr, fast_ptr, second_half;
    public static void main(String[] args) {
        PalindromeList llist = new PalindromeList();

        int str[] = {1,2,1,5,1,2,1};
        for (int i = 0; i < 7; i++) {
            llist.push(str[i]);
        }
        int res = llist.lPalin(llist.head);
        System.out.println("Res: "+res);
    }
    public static int lPalin(ListNode head) {
        slow_ptr = head;
        fast_ptr = head;
        ListNode prev_of_slow_node = head;
        ListNode midnode = null;
        int res = 0;

        if(head != null && head.next != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                prev_of_slow_node = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            if(fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            second_half = slow_ptr;
            prev_of_slow_node.next = null;
            System.out.println("Midnode: "+midnode.val);
            reverse();
            res = compareLists(head, second_half);
        }
        return res;
    }

    public static void reverse() {
        ListNode prev = null, current_node = second_half, next;
        while (current_node != null) {
            next = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next;
        }
        second_half = prev;
    }

    public static int compareLists(ListNode node1, ListNode node2) {
        ListNode temp1 = node1, temp2 = node2;
        while (temp1 != null && temp2 != null) {
            if(temp1.val == temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return 0;
            }
        }

        if(temp1 == null && temp2 == null)
            return 1;

        return 0;
    }

    public void push(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void printList(ListNode ptr) {
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println("NULL");
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}