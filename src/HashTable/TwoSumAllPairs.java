package HashTable;

/*
Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

        Assumptions

        The given array is not null and has length of at least 2.

        Examples

        A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

        A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
*/

import java.util.*;

public class TwoSumAllPairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            // case: key found
            if (map.containsKey(array[i])) {
                for (int index : map.get(array[i])) {
                    ans.add(Arrays.asList(new Integer[]{index, i}));
                }
            }

            if (!map.containsKey(target - array[i])) {
                map.put(target - array[i], new ArrayList<>());
            }
            map.get(target - array[i]).add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSumAllPairs test = new TwoSumAllPairs();
        int[] arr = new int[]{3,9,1,2,3};
        System.out.println(test.allPairs(arr, 4));
    }
}
