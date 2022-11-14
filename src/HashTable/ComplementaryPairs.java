package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ComplementaryPairs {
    public long complementaryPairs(String[] arr) {
        Map<Long, Long> map = new HashMap<>();
        long res = 0;
        for (String str : arr) {
            long bitMask = 0;
            for (char c : str.toCharArray()) {
                bitMask ^= (1 << (int) (c - 'a'));
            }

            // add matching
            if (map.containsKey(bitMask)) {
                res += map.get(bitMask);
            }

            // add additional letters
            for (int i = 0; i < 26; i++) {
                res += map.getOrDefault(bitMask ^ (1 << i), (long) 0);
            }

            // update
            map.put(bitMask, map.getOrDefault(bitMask, (long) 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        ComplementaryPairs test = new ComplementaryPairs();
        String[] arr = new String[]{"ball", "all", "call", "bal"};
        System.out.println(test.complementaryPairs(arr));
    }
}
