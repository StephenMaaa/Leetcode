package BinarySearch;

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

        Your algorithm's runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].

        Example
        Given [1, 3, 3, 3, 5, 5, 7], and target value 3,
        return [1, 3].
*/

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;

public class SearchInRange {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int[] range(int[] array, int target) {
        int[] range = new int[2];
        Arrays.fill(range, -1);

        // binary search for the first occurrence
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                range[0] = mid;
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // edge case
        if (range[0] == -1) {
            return range;
        }

        // binary search for the last occurrence
        left = range[0];
        right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                range[1] = mid;
                left = mid + 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return range;
    }

    public static void main(String[] args) {
        SearchInRange test = new SearchInRange();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.range(arr, 9)));
    }
}
