package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];

            // check
            int firstIndex = target.indexOf(s);
            int lastIndex = target.lastIndexOf(s);

            if (firstIndex == 0) {
                String complement = target.substring(s.length(), target.length());
                count += map.getOrDefault(complement, 0);
            }

            if (lastIndex == target.length() - s.length()) {
                String complement = target.substring(0, lastIndex);
                count += map.getOrDefault(complement, 0);
            }

            // update
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        ConcatenationEqualToTarget test = new ConcatenationEqualToTarget();
        String[] arr = new String[]{"1","111"};
        System.out.println(test.numOfPairs(arr, "11"));
    }
}
