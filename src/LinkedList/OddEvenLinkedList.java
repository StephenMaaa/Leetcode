package LinkedList;

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

        The first node is considered odd, and the second node is even, and so on.

        Note that the relative order inside both the even and odd groups should remain as it was in the input.

        You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/

public class OddEvenLinkedList {
    // approach 1 - Iteration TC: O(n) SC: O(1)
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode currO = odd;
        ListNode currE = even;

        // iteration
        int count = 1;
        while (head != null) {
            // case 1: even
            // case 2: odd
            if (count % 2 == 0) {
                currE.next = head;
                currE = currE.next;
            } else {
                currO.next = head;
                currO = currO.next;
            }
            head = head.next;
            count++;
        }

        // cut off
        currO.next = null;
        currE.next = null;

        // merge
        currO.next = even.next;
        return odd.next;
    }
}
