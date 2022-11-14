package LinkedList;

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

        Input:  1->2->3->3->4->4->5

        Output: 1->2->5

        Input:  1->1->1

        Output: NULL
*/

public class RemoveExtraDupFromSortedList {
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
                head = head.next;
            } else {
                ListNode temp = head.next;
                head.next = null;
                curr.next = head;
                head = temp;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveExtraDupFromSortedList test = new RemoveExtraDupFromSortedList();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(5);
        n1.next.next.next.next = new ListNode(5);
        ListNode head = test.removeDup(n1);
    }
}
