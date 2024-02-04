package Array;

/*
LeetCode 128

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

        For example,
        Given [95, 5, 3, 93, 2, 91, 92, 4]
        The longest consecutive elements sequence is [2, 3, 4, 5]. Return its length: 4.
*/

import java.util.*;

public class LongestConsecutiveSequence {
//    // approach 1 - Sort + Linear Scan TC: O(nlogn) SC: O(logn)
//    public int longestConsecutive(int[] array) {
//        // sort
//        Arrays.sort(array);
//
//        int max = 0;
//        int count = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            // case 1: consecutive
//            // case 2: otherwise
//            if (i == 0 || array[i] == array[i - 1] + 1) {
//                count++;
//            } else {
//                count = 1;
//            }
//
//            max = Math.max(max, count);
//        }
//        return max;
//    }
//
//    // approach 2 - Union Find TC: O(nlogn) SC: O(n)
//    public int longestConsecutive2(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] parent = new int[nums.length];
//        int[] size = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//
//        // union find
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                // check left and right
//                if (map.containsKey(nums[i] - 1)) {
//                    union(i, map.get(nums[i] - 1), parent, size);
//                }
//
//                if (map.containsKey(nums[i] + 1)) {
//                    union(i, map.get(nums[i] + 1), parent, size);
//                }
//
//                map.put(nums[i], i);
//            }
//        }
//
//        // update max
//        int max = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (i == parent[i]) {
//                max = Math.max(max, size[i]);
//            }
//        }
//        return max;
//    }
//
//    private void union(int u, int v, int[] parent, int[] size) {
//        u = find(u, parent);
//        v = find(v, parent);
//
//        if (u == v) {
//            return;
//        }
//
//        if (size[u] < size[v]) {
//            parent[u] = v;
//            size[v] += size[u];
//        } else {
//            parent[v] = u;
//            size[u] += size[v];
//        }
//    }
//
//    private int find(int i, int[] parent) {
//        // base case
//        if (i != parent[i]) {
//            parent[i] = find(parent[i], parent);
//        }
//        return parent[i];
//    }
//
//    // approach 3 - Linear Scan TC: O(n) SC: O(n)
//    public int longestConsecutive3(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // find the start of a sequence
//            if (!set.contains(nums[i] - 1)) {
//                int curr = nums[i];
//                int count = 1;
//                while (set.contains(curr + 1)) {
//                    curr++;
//                    count++;
//                }
//
//                max = Math.max(max, count);
//            }
//        }
//        return max;
//    }

    // approach 1: Set + Linear Scan TC: O(n) SC: O(n)
    public int longestConsecutive(int[] nums) {
        // initialization
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int max = 0;
        // scan
        for (int i = 0; i < nums.length; i++) {
            // check
            if (!set.contains(nums[i] - 1)) {
                int curr = nums[i];
                int count = 1;

                // update
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        int[] arr = new int[]{100, 4, 4, 200, 1, 3, 2};
        System.out.println(test.longestConsecutive(arr));
    }
}
