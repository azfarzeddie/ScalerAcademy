package LinkedList;

import Util.ListNode;
import Util.ScalerUtils;

import java.util.Scanner;

public class LinkedListOps {
    static ScalerUtils utils = new ScalerUtils();
    static ListNode head;
    public static void insert_node(int position, int value) {
        ListNode currNode = head;
        ListNode prevNode = null;
        int count = 0;
        if(head == null) {
            head = new ListNode(value);
            head.next = null;
            prevNode = null;
        } else {
            while(count < position-1) {
                prevNode = currNode;
                currNode = currNode.next;
                count++;
            }
            currNode = new ListNode(value);
            prevNode.next = currNode;
        }
        //utils.printLinkedList(head);
    }

    public static void delete_node(int position) {
        int count = 1;
            if(head == null) {
                return;
            }
            ListNode currNode = head;
            if(position == 0) {
                head = currNode.next;
            return;
        }
        else {
            while(currNode != null && count < position) {
                currNode = currNode.next;
                count++;
            }
            if(currNode==null || currNode.next==null)
                return;
            ListNode next = currNode.next.next;
            currNode.next = next;
        }
        //utils.printLinkedList(head);
    }

    public static void print_ll() {
        utils.printLinkedList(head);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases=0, position=0, value=0;
        cases = s.nextInt();
        for(int i=0; i<cases; i++) {
            char ch = s.next().charAt(0);
            switch(ch) {
                case 'i':
                    position = s.nextInt();
                    value = s.nextInt();
                    insert_node(position, value);
                    break;
                case 'd':
                    position = s.nextInt();
                    delete_node(position);
                    break;
                case 'p':
                    print_ll();
                    System.out.println();
                    break;
                default:
                    System.out.println("Check Your Input");
            }
        }
    }
}
