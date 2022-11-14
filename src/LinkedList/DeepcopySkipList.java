package LinkedList;

/*
A Skip List is a special type of linked list, where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.

        Make a deep copy of the original skip list.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DeepcopySkipList {
    public class SkipListNode {
        public int value;
        public SkipListNode next;
        public SkipListNode forward;
        public SkipListNode(int value) {
            this.value = value;
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    public SkipListNode copy(SkipListNode head) {
        // edge case
        if (head == null) {
            return null;
        }
        
        // initialization
        Map<SkipListNode, SkipListNode> map = new HashMap<>();
//        Deque<SkipListNode> queue = new ArrayDeque<>();
        SkipListNode newHead = new SkipListNode(head.value);
        SkipListNode curr = newHead;
        map.put(head, newHead);
//        queue.add(head);

        while (head != null) {
            // check next pointer
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new SkipListNode(head.next.value));
                }
                curr.next = map.get(head.next);
            }

            // check forward pointer
            if (head.forward != null) {
                if (!map.containsKey(head.forward)) {
                    map.put(head.forward, new SkipListNode(head.forward.value));
                }
                curr.forward = map.get(head.forward);
            }

            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }
}
