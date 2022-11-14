package LinkedList;

/*
Merge K sorted lists into one big sorted list in ascending order.

        Assumptions

        ListOfLists is not null, and none of the lists is null.
*/

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode merge(List<ListNode> listOfLists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        // initialize
        for (int i = 0; i < listOfLists.size(); i++) {
            if (listOfLists.get(i) != null) {
                minHeap.offer(listOfLists.get(i));
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return head.next;
    }
}
