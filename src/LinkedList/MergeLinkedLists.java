package LinkedList;

import java.util.List;

/*
Merge two sorted lists into one large sorted list.

        Examples

        L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
        L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
        L1 = null, L2 = null, merge L1 and L2 to null
*/
public class MergeLinkedLists {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        // merge the smaller node
        while (one != null && two != null) {
            if (one.val < two.val) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        // add remaining ones
        if (one != null) {
            curr.next = one;
        }

        // add remaining twos
        if (two != null) {
            curr.next = two;
        }
        return head.next;
    }

    // approach 1 - Iteration TC: O(m + n) SC: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // merge
        while (list1 != null && list2 != null) {
            // case 1: list1.val < list2.val
            // case 2: otherwise
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // add remaining nodes
        if (list1 == null) {
            curr.next = list2;
        } else if (list2 == null) {
            curr.next = list1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeLinkedLists test = new MergeLinkedLists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head = test.mergeTwoLists(head1, head2);
    }
}
