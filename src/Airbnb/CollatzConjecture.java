package Airbnb;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {

    public int longestStep(int n) {
        // edge case
        if (n < 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int step = countStep(i, map);
            map.put(i, step);
            max = Math.max(max, step);
        }
        return max;
    }

    private int countStep(int i, Map<Integer, Integer> map) {
        // base case
        if (i <= 1) {
            return 1;
        }

        if (map.containsKey(i)) {
            return map.get(i);
        }

        // recursive case
        if (i % 2 == 0) {
            return countStep(i / 2, map);
        } else {
            return countStep(i * 3 + 1, map);
        }
    }
}
