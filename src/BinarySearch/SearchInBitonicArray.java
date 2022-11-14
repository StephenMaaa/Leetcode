package BinarySearch;

/*
Search for a target number in a bitonic array, return the index of the target number if found in the array, or return -1.

        A bitonic array is a combination of two sequence: the first sequence is a monotonically increasing one and the second sequence is a monotonically decreasing one.

        Assumptions:

        The array is not null.
        Examples:

        array = {1, 4, 7, 11, 6, 2, -3, -8}, target = 2, return 5.
*/

public class SearchInBitonicArray {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int search(int[] array, int target) {
        // edge case
        if (array == null || array.length == 0) {
            return -1;
        }

        // search for peak
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // case 1: arr[mid] == target
            // case 2: arr[left - mid] in ascending order
            // case 3: arr[mid - right] in ascending order
            if (array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left;

        // binary search in ascending array [0 - peak]
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = peak;
        right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInBitonicArray test = new SearchInBitonicArray();
        int[] arr = new int[]{};
        System.out.println(test.search(arr, 4));
    }
}
