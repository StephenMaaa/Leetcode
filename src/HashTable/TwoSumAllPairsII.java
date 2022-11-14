package HashTable;

/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

        Assumptions

        The given array is not null and has length of at least 2
        The order of the values in the pair does not matter
        Examples

        A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
*/

import java.util.*;

public class TwoSumAllPairsII {
//    public List<List<Integer>> allPairs(int[] array, int target) {
//        // sort
//        Arrays.sort(array);
//        List<List<Integer>> ans = new ArrayList<>();
//        Map<Integer, Boolean> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            // case: arr[i] found at first time
//            if (map.containsKey(array[i]) && map.get(array[i])) {
//                ans.add(Arrays.asList(array[i], target - array[i]));
//                map.put(array[i], false);
//            }
//            if (!map.containsKey(target - array[i])) {
//                map.put(target - array[i], true);
//            }
//        }
//        return ans;
//    }

    public List<List<Integer>> allPairs(int[] array, int target) {
        // sort
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            // case: duplicate
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }

            if (array[left] + array[right] == target) {
                ans.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoSumAllPairsII test = new TwoSumAllPairsII();
        int[] arr = new int[]{2, 1, 3, 2, 4, 3, 4, 2};
        System.out.println(test.allPairs(arr, 6));
    }
}
