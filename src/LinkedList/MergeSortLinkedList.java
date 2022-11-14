package LinkedList;

/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort algorithm should be used to solve this problem.

        Examples

        null, is sorted to null
        1 -> null, is sorted to 1 -> null
        1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
        4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
*/

public class MergeSortLinkedList {
    // time complexity: O(nlogn)
    // space complexity: O(logn)
    public ListNode mergeSort(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode second = mergeSort(middle.next);
        middle.next = null;
        head = mergeSort(head);
        return merge(head, second);
    }

    private ListNode findMiddle(ListNode head) {
        // edge case
        if (head == null) {
            return null;
        }

        ListNode pointerA = head;
        ListNode pointerB = head;
        while (pointerB.next != null && pointerB.next.next != null) {
            pointerA = pointerA.next;
            pointerB = pointerB.next.next;
        }
        return pointerA;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (a != null && b != null) {
            // case 1: a.val < b.val
            // case 2: a.val >= b.val
            if (a.val < b.val) {
                head.next = a;
                a = a.next;
            } else {
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }

        if (a != null) {
            head.next = a;
        }

        if (b != null) {
            head.next = b;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSortLinkedList test = new MergeSortLinkedList();
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(test.mergeSort(head));
    }
}
