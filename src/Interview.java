
/*Coding Question:

        Write a short program to calculate factorial and output factorial(n) from 0..6 inclusive.
        Expected result is [1, 1, 2, 6, 24, 120, 720] (formatting optional and no user input required).


        For Reference: n! = n *(n-1)!
        or factorial of n (n!) = 1 * 2 * 3 * 4.....n
*/

import java.util.ArrayList;
import java.util.List;

// idea: just factorial from 0 - 6
// n! = 1 * 2 * 3 * (n - 1) * n
// (n - 1)! -> n * (n - 1)! -> n!
// for loop
public class Interview {
    class ListNode {
        ListNode prev;
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    // approach 1 - Recursion TC: O(n) SC: O(n)
    public ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive case
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

    // approach 2 - Iteration TC: O(n) SC: O(1)
    public ListNode reverseListII(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

//    // approach 2 - Iteration TC: O(n) SC: O(1)
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while (curr != null) {
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev;
//    }
//    // iteration
//    public List<Integer> getFactorial() {
//        List<Integer> res = new ArrayList<>();
//        // base case
//        res.add(1);
//        helper(1, res);
//        return res;
//    }
//
//    private void helper(int count, List<Integer> res) {
//        // recurisve case
//        // rule: (n - 1)! -> n * (n - 1)! -> n!
//        if (count < 7) {
//            int factorial = res.get(res.size() - 1);
//            res.add(factorial * count);
//            helper(count + 1, res);
//        }
//    }
//
//    public static void main(String[] args) {
//        Interview test = new Interview();
//        // Expected result is [1, 1, 2, 6, 24, 120, 720]
//        System.out.println(test.getFactorial());
//    }
}
