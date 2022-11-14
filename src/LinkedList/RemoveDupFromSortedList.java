package LinkedList;

/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

        Input: 1->1->2

        Output: 1->2
*/

public class RemoveDupFromSortedList {
    // time complexity: O(n)
    // space complexity: O(1)
    public ListNode removeDup(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head != null) {
            // case 1: dup
            // case 2: otherwise
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            }
            curr.next = head;
            head = head.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDupFromSortedList test = new RemoveDupFromSortedList();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(5);
        n1.next.next.next.next = new ListNode(5);
        ListNode head = test.removeDup(n1);
    }
}
