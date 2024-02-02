package HashTable;

/*
LeetCode 692

Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

        Assumptions

        the composition is not null and is not guaranteed to be sorted
        K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
        Return

        a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
        Examples

        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
        Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
*/

import java.util.*;

public class TopKFrequentWords {
//    public class Cell {
//        String s;
//        int n;
//        public Cell(String s, int n) {
//            this.s = s;
//            this.n = n;
//        }
//    }

//    public class MyComparator implements Comparator<Cell> {
//        @Override
//        public int compare(Cell a, Cell b) {
//            if (a.n == b.n) return 0;
//            return a.n < b.n ? -1 : 1;
//        }
//    }

//    public String[] topKFrequent(String[] combo, int k) {
//        HashMap<String, Integer> map = new HashMap();
//        for (String s : combo) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//
//        // min heap
//        PriorityQueue<Cell> pq = new PriorityQueue<>((m, n) -> n.n - m.n);
//        for (String key : map.keySet()) {
//            if (pq.size() < k) {
//                pq.offer(new Cell(key, map.get(key)));
//            } else if (pq.peek().n < map.get(key)) {
//                pq.poll();
//                pq.offer(new Cell(key, map.get(key)));
//            }
//        }
//
//        String[] ans = new String[pq.size()];
//        for (int i = ans.length - 1; i >= 0; i--) {
//            ans[i] = pq.poll().s;
//        }
//        return ans;
//    }

//    // approach 1 - Map + PriorityQueue (MinHeap) TC: O(nlogk) SC: O(n + k)
//    public List<String> topKFrequent(String[] words, int k) {
//        // generate a frequency map
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
//        }
//
//        // maintain a minHeap of size k
//        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
//        for (String key : map.keySet()) {
//            minHeap.offer(key);
//            // check
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//
//        // populate
//        Deque<String> queue = new ArrayDeque<>();
//        while (!minHeap.isEmpty()) {
//            queue.offerFirst(minHeap.poll());
//        }
//        return new ArrayList<>(queue);
//    }

//    // approach 2 - Map + Count Array (Bucket Sort) + Trie TC: O(n) SC: O(n)
//    public List<String> topKFrequent(String[] words, int k) {
//        // generate a frequency map
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
//        }
//
//        // generate an indexing map
//        Map<Integer, String> indexMap = new HashMap<>();
//        int i = 0;
//        for (String key : map.keySet()) {
//            indexMap.put(i++, key);
//        }
//
//        // need a trie data structure to save O(logk) in each comparison
//    }

    // approach 1: Map + Priority Queue TC: O(nlogk) SC: O(n + k)
    public List<String> topKFrequent(String[] words, int k) {
        // initialization
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));

        // populate
        for (String key : map.keySet()) {
            pq.offer(key);

            // check
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // process
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords test = new TopKFrequentWords();
        System.out.println(test.topKFrequent(arr, 1));
//        String[] ans = test.topKFrequent(arr, 4);
//        System.out.println(Arrays.toString(ans));
    }
}
