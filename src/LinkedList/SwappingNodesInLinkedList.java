package LinkedList;

/*
You are given the head of a linked list, and an integer k.

        Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
*/

public class SwappingNodesInLinkedList {
    // approach 1 - Pointers TC: O(n) SC: O(1)
    public ListNode swapNodes(ListNode head, int k) {
        ListNode pointerA = head;
        ListNode pointerB = head;

        // get the kth node from the beginning
        for (int i = 1; i < k; i++) {
            pointerA = pointerA.next;
        }
        ListNode nodeA = pointerA;

        // get the kth node from the end
        while (pointerA.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        // swap
        int temp = nodeA.val;
        nodeA.val = pointerB.val;
        pointerB.val = temp;
        return head;
    }
}
