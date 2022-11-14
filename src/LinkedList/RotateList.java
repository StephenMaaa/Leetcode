package LinkedList;

/*
Given the head of a linked list, rotate the list to the right by k places.
*/

public class RotateList {
    // approach 1 - Two Pointers TC: O(n) SC: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        // get size and the last node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int size = 0;
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }
        ListNode tail = curr;

        // edge case
        if (size == 0 || k % size == 0) {
            return head;
        }
        // calculate shift index
        k %= size;

        // get the last kth node
        ListNode fast = dummy;
        curr = dummy;
        int count = 0;
        while (count < k) {
            fast = fast.next;
            count++;
        }

        while (fast.next != null) {
            curr = curr.next;
            fast = fast.next;
        }

        // reconnect
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead; 
    }
}
