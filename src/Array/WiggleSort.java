package Array;

/*
Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

        You may assume the input array always has a valid answer.



        Example 1:

        Input: nums = [3,5,2,1,6,4]
        Output: [3,5,1,6,2,4]
        Explanation: [1,6,2,5,3,4] is also accepted.
        Example 2:

        Input: nums = [6,6,5,6,3,8]
        Output: [6,6,5,6,3,8]
*/

import java.util.LinkedList;
import java.util.List;

public class WiggleSort {
    // approach 1 - Swap TC: O(n) SC: O(1)
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSort test = new WiggleSort();
        int[] arr = new int[]{6, 6, 5, 6, 3, 8};
        test.wiggleSort(arr);
    }
}
