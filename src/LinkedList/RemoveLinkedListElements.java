package LinkedList;

/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
*/

public class RemoveLinkedListElements {
    // approach 1 - Iteration TC: O(n) SC: O(1)
    public ListNode removeElements(ListNode head, int val) {
        // iteration
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // one pass
        while (curr.next != null) {
            // check
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
