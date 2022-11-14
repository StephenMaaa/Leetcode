package LinkedList;

/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

        k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

        You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode end = dummy;
        ListNode curr = head;
        while (curr != null) {
            // reverse k nodes
            ListNode prev = null;
            ListNode next = null;
            ListNode reference = curr;
            int count = 0;
            while (count < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // check
            if (count == k) {
                end.next = prev;
                end = reference;
            } else {
                // reverse back
                curr = prev;
                prev = null;
                next = null;
                while (curr != null) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                end.next = prev;
            }
        }
        return dummy.next;
    }
}
