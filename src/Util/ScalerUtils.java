package Util;

import Heaps.NMaxPairCombination;

import java.util.PriorityQueue;

public class ScalerUtils {
    public void printArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArray (Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArray (String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printLinkedList (ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void printLinkedList (ListNodeDown head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    public void printLinkedListRandom (ListNodeRandom head) {
        ListNodeRandom head1 = head;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.random;
        }
    }

    public void printPriorityQueue (PriorityQueue<NMaxPairCombination.Pair> queue) {
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.poll().sum + " ");
        }
        System.out.println();
    }
}
