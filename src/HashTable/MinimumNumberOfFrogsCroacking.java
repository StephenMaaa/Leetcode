package HashTable;

/*
You are given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, multiple frogs can croak at the same time, so multiple "croak" are mixed.

        Return the minimum number of different frogs to finish all the croaks in the given string.

        A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of a valid "croak" return -1.
*/

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfFrogsCroacking {
    // approach 1 - Map TC: O(n) SC: O(1)
    public int minNumberOfFrogs(String croakOfFrogs) {
        // generate an index map
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 1);
        map.put('r', 2);
        map.put('o', 3);
        map.put('a', 4);
        map.put('k', 5);
        int[] arr = new int[6];
        arr[0] = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int index = map.get(croakOfFrogs.charAt(i));

            // case 1: arr[index - 1] > arr[index]
            // case 2: otherwise
            if (arr[index - 1] > arr[index]) {
                arr[index]++;
                count = Math.max(count, arr[index]);

                // check
                if (index == arr.length - 1) {
                    for (int j = 1; j < arr.length; j++) {
                        arr[j]--;
                    }
                }
            } else {
                return -1;
            }
        }

        // check
        if (arr[1] > 0) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfFrogsCroacking test = new MinimumNumberOfFrogsCroacking();
        System.out.println(test.minNumberOfFrogs("crccoakroak"));
    }
}
