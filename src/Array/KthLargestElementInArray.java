package Array;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

        For example,
        Given [3,2,1,5,6,4] and k = 2, return 5.

        Note:
        You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

import java.util.Random;

public class KthLargestElementInArray {
    Random random = new Random();

    // time complexity: O(n)
    // space complexity: O(1)
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);

            // case 1: pivot == n - k
            // case 2: pivot < n - k
            // case 3: pivot > n - k
            if (pivot == nums.length - k) {
                return nums[pivot];
            } else if (pivot < nums.length - k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
//        int pivot = right; // or use random
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, pivot, right);
        pivot = right;
        for (int i = left; i < right; i++) {
            // case 1: arr[i] < pivot
            // case 2: arr[i] >= pivot
            if (nums[i] < nums[pivot]) {
                swap(nums, i, left++);
            }
        }
        swap(nums, left, pivot);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementInArray test = new KthLargestElementInArray();
        int[] arr = new int[]{8, 10, 2, 7, 4, 2, 13, 19, 6, 3, 3, 4, 5, 0, -1, 42, 32, 1, 6, 4};
        System.out.println(test.findKthLargest(arr, 3)); 
    }
}