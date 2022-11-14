package LinkedList;

/*
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

        The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

        For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
*/

public class DeleteTheMiddleNodeOfALinkedList {
    // approach 1 - Two Pointers TC: O(n) SC: O(1)
    public ListNode deleteMiddle(ListNode head) {
        // two pointers
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // find the middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next; 
    }
}
