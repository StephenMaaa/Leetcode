package LinkedList;

/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
*/

public class ReverseLinkedListII {
    // approach 1 - Pointers + Iteration TC: O(n) SC: O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        int count = 1;

        // first part
        while (count < left) {
            first = first.next;
            count++;
        }

        // second part (middle)
        ListNode curr = first.next;
        ListNode next = null;
        ListNode prev = null;

        // reverse
        while (count <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // concatenate
        first.next.next = curr;
        first.next = prev;
        return dummy.next; 
    }
}
