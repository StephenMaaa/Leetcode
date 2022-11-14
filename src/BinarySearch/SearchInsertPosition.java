package BinarySearch;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

        You must write an algorithm with O(log n) runtime complexity.
*/

public class SearchInsertPosition {
    // approach 1 - Binary Search TC: O(logn) SC: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;

            // case 1: target == arr[mid]
            // case 2: target < arr[mid]
            // case 3: target > arr[mid]
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return target <= nums[left] ? left : left + 1;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] arr = new int[]{1};
        System.out.println(test.searchInsert(arr, 1));
    }
}
