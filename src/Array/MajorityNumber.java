package Array;

/*
Given an integer array of length L, find the number that occurs more than 0.5 * L times.

        Assumptions

        The given array is not null or empty
        It is guaranteed there exists such a majority number
        Examples

        A = {1, 2, 1, 2, 1}, return 1
*/

import java.util.HashMap;
import java.util.Map;

public class MajorityNumber {
    // approach 1 - Map TC: O(n) SC: O(n)
    public int majority(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int majority = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                majority = key;
                break;
            }
        }
        return majority;
    }

    // approach 2 - Boyer Moore Majority-voting Algorithm TC: O(n) SC: O(1)
    public int majority2(int[] array) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            // base case
            if (count == 0) {
                candidate = array[i];
                count++;
            } else {
                if (candidate == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    // approach 1: Boyer Moore Algorithm TC: O(n) SC: O(1)
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // check candidate
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityNumber test = new MajorityNumber();
        int[] arr = new int[]{1, 2, 1, 2, 1};
        System.out.println(test.majorityElement(arr));
    }
}
