package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoringArray {
    // approach 1 - Sorting + Map + Greedy TC: O(nlogn) SC: O(n)
    public boolean boringArray(int[] a, int[] b) {
        // sort
        Arrays.sort(a);

        // generate a counting map for b
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], map.getOrDefault(b[i], 0) + 1);
        }

        // check
        for (int i = 0; i < a.length; i++) {
            // case 1: arr[i] matches
            // case 2: otherwise
            if (map.containsKey(a[i])) {
                int count = map.get(a[i]);
                if (count == 1) {
                    map.remove(a[i]);
                } else {
                    map.put(a[i], count - 1);
                }
            } else if (map.containsKey(a[i] + 1)) {
                int count = map.get(a[i] + 1);
                if (count == 1) {
                    map.remove(a[i] + 1);
                } else {
                    map.put(a[i] + 1, count - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    // approach 2 - Sorting + Greedy TC: O(nlogn) SC: O(n)
    public boolean boringArray2(int[] a, int[] b) {
        // sort
        Arrays.sort(a);
        Arrays.sort(b);

        // check
        for (int i = 0; i < a.length; i++) {
            // case 1: arr[i] matches
            // case 2: otherwise
            if (a[i] != b[i] && a[i] + 1 != b[i]) {
                return false;
            }
        }
        return true; 
    }
}
