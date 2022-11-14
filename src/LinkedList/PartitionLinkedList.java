package LinkedList;

/*
Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.

        Examples

        L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
*/

import java.util.List;

public class PartitionLinkedList {
//    public ListNode partition(ListNode head, int target) {
//        if (head == null) {
//            return head;
//        }
//        ListNode d1 = new ListNode(0);
//        ListNode d2 = new ListNode(0);
//        ListNode curr1 = d1;
//        ListNode curr2 = d2;
//        while (head != null) {
//            if (head.value < target) {
//                curr1.next = head;
//                head = head.next;
//                curr1 = curr1.next;
//                curr1.next = null;
//            } else {
//                curr2.next = head;
//                head = head.next;
//                curr2 = curr2.next;
//                curr2.next = null;
//            }
//        }
//        curr1.next = d2.next;
//        return d1.next;
//    }

//    public ListNode partition(ListNode head, int target) {
//        if (head == null) {
//            return head;
//        }
//        ListNode d1 = new ListNode(0);
//        ListNode d2 = new ListNode(0);
//        ListNode curr1 = d1;
//        ListNode curr2 = d2;
//        while (head != null) {
//            if (head.value < target) {
//                curr1.next = head;
//                curr1 = curr1.next;
//            } else {
//                curr2.next = head;
//                curr2 = curr2.next;
//            }
//            head = head.next;
//        }
//        curr1.next = d2.next;
//        curr2.next = null;
//        return d1.next;
//    }

    // approach 1 - Two Pointers TC: O(n) SC: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode currF = first;
        ListNode currS = second;

        // iteration
        while (head != null) {
            // case 1: head.val < x
            // case 2: head.val >= x
            if (head.val < x) {
                currF.next = head;
                currF = currF.next;
            } else {
                currS.next = head;
                currS = currS.next;
            }
            head = head.next;
        }

        // concatenate
        currF.next = second.next;
        currS.next = null;
        return first.next;
    }
}

