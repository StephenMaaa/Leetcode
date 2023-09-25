package LinkedList;

/*
Given the head of a singly linked list, return the middle node of the linked list.

        If there are two middle nodes, return the second middle node.
*/

public class FindMiddleLinkedList {
    // approach 1: Two Pointers TC: O(n) SC: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // iterate
        while (fast != null && fast.next != null) {
            // move
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; 
    }
}
