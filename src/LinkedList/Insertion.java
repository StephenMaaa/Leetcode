package LinkedList;

/*
Insert a value in a sorted linked list.

        Examples

        L = null, insert 1, return 1 -> null
        L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
        L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
        L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
*/

public class Insertion {
    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode insert(ListNode head, int value) {
        ListNode curr = head;
        ListNode newNode = new ListNode(value);
        if (head == null || value < head.value) {
            newNode.next = head;
            return newNode;
        }

        while (curr.next != null && value > curr.next.value) {
//            if (curr.next == null) {
//                curr.next = new ListNode(value);
//                return head;
//            }
//            if (value < curr.next.value) {
//                newNode.next = curr.next;
//                curr.next = newNode;
//                return head;
//            } else {
//                curr = curr.next;
//            }
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}
