package LinkedList;

/*
Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.
*/

public class CycleNodeInLinkedList {
//    public ListNode cycleNode(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode a = head;
//        ListNode b = head.next;
//        while (b.next != null && b.next.next != null) {
//            // check cycle
//            if (a == b) {
//                // find the node where the cycle starts
//                a = a.next;
//                b = head;
//                while (a != b) {
//                    a = a.next;
//                    b = b.next;
//                }
//                return a;
//            }
//            a = a.next;
//            b = b.next.next;
//        }
//        return null;
//    }

    public ListNode cycleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;

            // check cycle
            if (a == b) {
                // find the node where the cycle starts
                b = head;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }

    // approach 1 - Two Pointers TC: O(n) SC: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // check cycle
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CycleNodeInLinkedList test = new CycleNodeInLinkedList();
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(test.detectCycle(head).val);
    }
}
