package Array;

/*
Given an unsorted array with all 0 or 1s. Return the length of the longest contiguous sub-array that contains equal numbers of 0s and 1s.

        Assumptions:

        The given array is not null.
        Examples:

        array = {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0}, the answer is 6 (the subarray is highlighted).
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualNumberOf1sAnd0s {
    // time complexity: O(n)
    // space complexity: O(n)
    public int longest(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            // update sum
            if (array[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // update max
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayWithEqualNumberOf1sAnd0s test = new LongestSubarrayWithEqualNumberOf1sAnd0s();
        int[] arr = new int[]{1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0};
        System.out.println(test.longest(arr));
    }
}
