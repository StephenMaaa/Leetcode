package LinkedList;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

        Implement the LRUCache class:

        LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        int get(int key) Return the value of the key if the key exists, otherwise return -1.
        void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        The functions get and put must each run in O(1) average time complexity.
*/

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // approach 1 - Doubly Linked List + Map
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // check existence
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // update
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        // check existence
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);

            // add to the head
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        } else {
            Node node = map.get(key);
            node.val = value;
            update(node);
        }

        // check out of capacity
        if (capacity < map.size()) {
            // remove the LRU node and remove from map
            Node lruNode = tail.prev;
            lruNode.prev.next = tail;
            tail.prev = lruNode.prev;
            map.remove(lruNode.key);
        }
    }

    private void update(Node node) {
        // move the current node to the head
        node.prev.next = node.next;
        node.next.prev = node.prev;

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}
