package BinarySearch;

/*
LeetCode 153

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

        [4,5,6,7,0,1,2] if it was rotated 4 times.
        [0,1,2,4,5,6,7] if it was rotated 7 times.
        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        Given the sorted rotated array nums of unique elements, return the minimum element of this array.

        You must write an algorithm that runs in O(log n) time.
*/

public class FindMinimumInRotatedSortedArray {
    // goal: find min
    // array: sorted
    // binary search
    // left, right
    // case 1: left side is sorted
    // case 2: right side is sorted

    // approach 1: Binary Search TC: O(logn) SC: O(1)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // binary search
        while (left < right) {
            int mid = (left + right) >> 1;

            // check
            // case 1: left side is sorted
            // case 2: right side is sorted
            if (nums[left] <= nums[mid]) {
                // case 1: right side is sorted
                // case 2: right side not sorted
                if (nums[mid] < nums[right]) {
                    right = mid - 1;
//                    return nums[left];
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
        int[] arr = new int[]{2, 1};
        System.out.println(test.findMin(arr));
    }
}
