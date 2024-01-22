package LinkedList;

/*
LeetCode 82

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
*/

import java.util.List;

public class RemoveDuplicatesFromSortedListII {
    // approach 1: Iteration TC: O(n) SC: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-200);

        ListNode next = dummy;
        ListNode curr = head;
        while (curr != null) {
            // check dup
            int val = curr.val;
            boolean flag = true;
            while (curr.next != null && curr.next.val == val) {
                flag = false;
                curr = curr.next;
            }

            // add
            if (flag) {
                next.next = curr;
                next = curr;
            }

            // move
            curr = curr.next;
            next.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII test = new RemoveDuplicatesFromSortedListII();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(5);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        ListNode head = test.deleteDuplicates(n1);
    }
}
