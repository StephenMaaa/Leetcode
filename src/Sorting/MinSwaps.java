package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwaps {
    public int minSwaps(int[] nums) {
        int count = 0;

        // sort
        int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);

        // track number's index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            // check
            if (nums[i] != sortedArr[i]) {
                int temp = nums[i];

                // fill in the correct number at index i
                swap(nums, i, map.get(sortedArr[i]));

                // update the index of the swapped numbers
                map.put(temp, map.get(sortedArr[i]));
                map.put(sortedArr[i], i);
                count++;
            }
        }
        return count;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MinSwaps test = new MinSwaps();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(test.minSwaps(arr));
    }
}
