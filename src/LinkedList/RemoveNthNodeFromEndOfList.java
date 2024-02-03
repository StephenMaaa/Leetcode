package LinkedList;

/*
LeetCode 19

Given a linked list, remove the nth node from the end of list and return its head.

        Assumptions
        If n is not valid, you do not need to do anything to the original list.
        Try to do this in one pass.

        Examples

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

public class RemoveNthNodeFromEndOfList {
//    // time complexity: O(n)
//    // space complexity: O(1)
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode nodeA = head;
//        ListNode nodeB = head;
//        // move nodeA to nth node
//        for (int i = 1; i < n; i++) {
//            if (nodeA == null && i < n) {
//                return head;
//            }
//            nodeA = nodeA.next;
//        }
//
//        // edge case
//        if (n <= 0 || nodeA == null) {
//            return head;
//        } else if (nodeA.next == null) {
//            return head.next;
//        }
//
//        nodeA = nodeA.next;
//        while (nodeA.next != null) {
//            nodeA = nodeA.next;
//            nodeB = nodeB.next;
//        }
//        nodeB.next = nodeB.next.next;
//        return head;
//    }
//
//    // time complexity: O(n)
//    // space complexity: O(1)
//    public ListNode removeNthFromEnd2(ListNode head, int n) {
//        ListNode pointerA = head;
//        ListNode pointerB = head;
//
//        // move to the Nth node
//        for (int i = 1; i < n; i++) {
//            pointerA = pointerA.next;
//        }
//
//        // edge case
//        if (pointerA.next == null) {
//            return head.next;
//        }
//
//        // move two pointers
//        pointerA = pointerA.next;
//        while (pointerA.next != null) {
//            pointerA = pointerA.next;
//            pointerB = pointerB.next;
//        }
//
//        // remove node
//        pointerB.next = pointerB.next.next;
//        return head;
//    }
//
//    // approach 1 - Two Pointers TC: O(n) SC: O(1)
//    public ListNode removeNthFromEnd3(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pointerA = dummy;
//        ListNode pointerB = dummy;
//
//        // move to the Nth node
//        for (int i = 1; i < n; i++) {
//            pointerA = pointerA.next;
//        }
//
//        // move two pointers
//        pointerA = pointerA.next;
//        while (pointerA.next != null) {
//            pointerA = pointerA.next;
//            pointerB = pointerB.next;
//        }
//
//        // remove node
//        pointerB.next = pointerB.next.next;
//        return dummy.next;
//    }

    // approach 1: Two Pointers TC: O(n) SC: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointerA = dummy;
        ListNode pointerB = dummy;

        // move the fast node
        for (int i = 0; i < n; i++) {
            pointerA = pointerA.next;
        }

        // move two pointers in the same pace
        while (pointerA.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        // remove the next
        pointerB.next = pointerB.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(2);
//        n1.next.next = new ListNode(3);
//        n1.next.next.next = new ListNode(4);
//        n1.next.next.next.next = new ListNode(5);
        ListNode head = test.removeNthFromEnd(n1, 1);
    }
}
