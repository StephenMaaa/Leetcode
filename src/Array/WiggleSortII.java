package Array;

/*
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

        You may assume the input array always has a valid answer.
*/

import java.util.Arrays;

public class WiggleSortII {
    // approach 1 - Sort + Swap TC: O(nlogn) SC: O(n)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] arr = nums.clone();
        int mid = (nums.length + 1) / 2;
        for (int i = 0, j = mid - 1, k = nums.length - 1; i < nums.length; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i < nums.length - 1) {
                nums[i + 1] = arr[k];
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSortII test = new WiggleSortII();
        int[] arr = new int[]{4, 5, 5, 6};
        test.wiggleSort(arr);
    }
}
