package HashTable;

/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    // approach 1 - Map + Set TC: O(n) SC: O(n)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int key : map.keySet()) {
            // check
            if (set.contains(map.get(key))) {
                return false;
            }
            set.add(map.get(key));
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences test = new UniqueNumberOfOccurrences();
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println(test.uniqueOccurrences(arr));
    }
}
