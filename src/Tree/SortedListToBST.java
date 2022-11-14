package Tree;

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
        For testing purpose, please make sure for any node in the result, its left sub-tree should have equal or only one more node than its right sub-tree.
        Example:
        Given ascending order list: 1→3→4→5→8→11

        return Binary Search Tree is

        5

        /        \

        3          11

        /      \      /

        1        4    8
*/

public class SortedListToBST {
    // time complexity: O(n)
    // space complexity: O(height)
    public TreeNode sortedListToBST(ListNode head) {
        // base case
        if (head == null) {
            return null;
        }

        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.value);
        ListNode left = head == mid ? null : head;
        ListNode right = mid.next;
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);
        return root;
    }

    private ListNode findMiddle(ListNode head) {
        // base case
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode last = null;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            last = slow;
            slow = slow.next;
        }

        // cut the linked list into two part
        if (last != null) {
            last.next = null;
        }
        return slow;
    }

    public static void main(String[] args) {
        SortedListToBST test = new SortedListToBST();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(11);
        TreeNode root = test.sortedListToBST(null);
    }
}
