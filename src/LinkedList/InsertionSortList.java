package LinkedList;

/*
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

        The steps of the insertion sort algorithm:

        Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
        At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
        It repeats until no input elements remain.
        The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
*/

public class InsertionSortList {
    // approach 1 - Insertion Sort TC: O(n^2) SC: O(1)
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            // insert
            next = curr.next;
            curr.next = null;
            head = insert(head, curr);
            curr = next;
        }
        return head;
    }

    private ListNode insert(ListNode head, ListNode target) {
        // edge case
        if (head == target) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.val < target.val) {
            prev = curr;
            curr = curr.next;
        }

        target.next = curr;
        // insert
        if (prev != null) {
            prev.next = target;
        } else {
            head = target;
        }
        return head;
    }

    // approach 2 - Insertion Sort TC: O(n^2) SC: O(1)
    public ListNode insertionSortList2(ListNode head) {
        // edge case
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode lastSorted = head;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummy;
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = test.insertionSortList2(head);
    }
}
