package LinkedList;

/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        Example

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

        Output: 7 -> 0 -> 8
*/

import Sorting.QuickSort;

import java.util.Arrays;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1 = reverse(l1);
//        l2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int total = 0;
        while (l1 != null || l2 != null || total != 0) {
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(total % 10);
            curr = curr.next;
            total /= 10;
        }
        return dummy.next;
    }

//    private ListNode reverse(ListNode head) {
//        ListNode curr = head;
//        ListNode prev = null;
//        ListNode next = null;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(6);

        ListNode n2 = new ListNode(6);
        n2.next = new ListNode(3);
//        n2.next.next = new ListNode(4);

        AddTwoNumbers test = new AddTwoNumbers();
        ListNode ans = test.addTwoNumbers(n1, n2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
