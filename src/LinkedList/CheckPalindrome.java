package LinkedList;

/*
Given a linked list, check whether it is a palindrome.

        Examples:

        Input:   1 -> 2 -> 3 -> 2 -> 1 -> null

        output: true.

        Input:   1 -> 2 -> 3 -> null

        output: false.

        Requirements:

        Space complexity must be O(1)
*/

import java.util.List;

//class ListNode {
//    public int value;
//    public ListNode next;
//
//    public ListNode(int value) {
//        this.value = value;
//        next = null;
//    }
//}

public class CheckPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode mid = getMiddle(head);
        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        mid.next = null;
        secondHalf = reverse(secondHalf);
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(6);
        n1.next.next.next = new ListNode(2);
        n1.next.next.next.next = new ListNode(0);

        CheckPalindrome test = new CheckPalindrome();
        System.out.println(test.isPalindrome(n1));
    }
}
