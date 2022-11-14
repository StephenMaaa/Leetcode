package LinkedList;

/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
*/

import java.util.HashMap;
import java.util.Map;

public class DeepcopyLinkedListWithRandomPointer {
    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        public RandomListNode(int value) {
            this.value = value;
        }
    }

    public RandomListNode copy(RandomListNode head) {
        // edge case
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        RandomListNode curr = newHead;
        map.put(head, newHead);
        while (head != null) {
            // add head.next
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                curr.next = map.get(head.next);
            }
            // add head.random
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                curr.random = map.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }
}
