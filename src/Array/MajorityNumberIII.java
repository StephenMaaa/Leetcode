package Array;

/*
Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

        Assumptions

        The given array is not null or empty
        K >= 2
        Examples

        A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
        A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
        A = {2, 1}, K = 2, return []
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityNumberIII {
    // time complexity: O(n)
    // space complexity: O(n)
    public List<Integer> majority(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > array.length / k) {
                res.add(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityNumberIII test = new MajorityNumberIII();
        int[] arr = new int[]{1, 2, 1, 2, 1};
        System.out.println(test.majority(arr, 3));
    }
}
