package LinkedList;

/*
Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java), false (C++), -1(Python).
*/

import sun.misc.LRUCache;

import java.util.*;

//public class LRUCache {
//    }
public class LRUCacheSol<K, V> {
    public class Node<K, V> {
        K key;
        V val;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;
    Map<K, Node<K, V>> map;
    LinkedList<Node<K, V>> linkedList;

    // limit is the max capacity of the cache
    public LRUCacheSol(int limit) {
        this.size = limit;
        this.map = new HashMap<>();
        this.linkedList = new LinkedList<>();
    }

    public void set(K key, V value) {
        // case 1: key exists
        // case 2: otherwise
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            linkedList.remove(node);
            node.val = value;
            linkedList.offerFirst(node);
        } else {
            // case 1: not full
            if (map.size() < size) {
                Node<K, V> node = new Node<>(key, value);
                map.put(key, node);
                linkedList.offerFirst(node);
            } else {
                // remove the least recent item
                Node<K, V> removed = linkedList.pollLast();
                map.remove(removed.key);

                // update
                Node<K, V> node = new Node<>(key, value);
                map.put(key, node);
                linkedList.offerFirst(node);
            }
        }
    }

    public V get(K key) {
        // edge case
        if (!map.containsKey(key)) {
            return null;
        }

        // update
        Node<K, V> node = map.get(key);
        linkedList.remove(node);
        linkedList.offerFirst(node);
        return node.val;
    }

    public static void main(String[] args) {
        // capactity=2;get(1),set(1,1),set(2,2),get(2),get(1),set(3,3),get(1),get(2),get(3),set(2,2),set(1,1),get(3)
        LRUCacheSol<Integer, Integer> test = new LRUCacheSol(2);
        List<Integer> list = new ArrayList<>();
        list.add(test.get(1));
        test.set(1, 1);
        test.set(2, 2);
        list.add(test.get(2));
        list.add(test.get(1));
        test.set(3, 3);
        list.add(test.get(1));
        list.add(test.get(2));
        list.add(test.get(3));
        test.set(2, 2);
        test.set(1, 1);
        list.add(test.get(3));
        System.out.println(list);
        // [null, 2, 1, 1, null, 3, null]
    }
}
