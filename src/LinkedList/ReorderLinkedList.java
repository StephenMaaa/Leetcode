package LinkedList;

/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

        Examples

        L = null, is reordered to null
        L = 1 -> null, is reordered to 1 -> null
        L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
        L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
*/

import java.util.List;

public class ReorderLinkedList {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
//        ListNode secondHalf = getMiddle(head);
//        ListNode curr = head;
//        while (curr.next != secondHalf) {
//            curr = curr.next;
//        }
//        curr.next = null;
        secondHalf = reverse(secondHalf);
        return merge(head, secondHalf);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (n1 != null && n2 != null) {
            curr.next = n1;
            n1 = n1.next;
            curr = curr.next;
            curr.next = n2;
            n2 = n2.next;
            curr = curr.next;
        }
        if (n1 != null) {
            curr.next = n1;
        }
        return head.next;
    }
}
