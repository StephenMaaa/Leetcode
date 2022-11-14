package BinarySearch;

/*
A peak element is an element that is strictly greater than its neighbors.

        Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

        You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

        You must write an algorithm that runs in O(log n) time.
*/

public class FindPeakElement {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] < arr[mid + 1]
            // case 2: arr[mid] > arr[mid + 1]
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement test = new FindPeakElement();
        int[] arr = new int[]{0, 1};
        System.out.println(test.findPeakElement(arr));
    }
}
