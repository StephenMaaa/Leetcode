package LinkedList;

/*
Reverse pairs of elements in a singly-linked list.

        Examples

        L = null, after reverse is null
        L = 1 -> null, after reverse is 1 -> null
        L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
        L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
*/

public class ReverseLinkedListInPairs {
//    public ListNode reverseInPairs(ListNode head) {
//        // base case
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode next = reverseInPairs(head.next.next);
//        ListNode newHead = head.next;
//        newHead.next = head;
//        head.next = next;
//        return newHead;
//    }

//    // approach 1 - Recursion TC: O(n) SC: O(n)
//    public ListNode swapPairs(ListNode head) {
//        // base case
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // recursive case
//        // swap
//        int temp = head.value;
//        head.value = head.next.value;
//        head.next.value = temp;
//        head.next.next = swapPairs(head.next.next);
//        return head;
//    }

    // approach 2 - Iteration TC: O(n) SC: O(1)
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            // swap
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
            curr = curr.next.next;
        }
        return head; 
    }
}
