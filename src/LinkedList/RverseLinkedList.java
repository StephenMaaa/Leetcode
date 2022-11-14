package LinkedList;

/*
Reverse a singly-linked list iteratively.

        Examples

        L = null, return null
        L = 1 -> null, return 1 -> null
        L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
*/

import DFS.AllPermutations;

import java.util.ArrayList;
import java.util.List;

public class RverseLinkedList {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    // approach 1 - Iteration TC: O(n) SC: O(1)
    public ListNode reverse(ListNode head) {
        // Write your solution here
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // approach 2 - Recursion TC: O(n) SC: O(n)
    public ListNode reverse2(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
