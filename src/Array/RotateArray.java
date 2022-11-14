package Array;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
*/

public class RotateArray {
    // approach 1 - Swap + Count TC: O(n) SC: O(1)
    public void rotate(int[] nums, int k) {
        int count = 0;
        int shiftFrom = 0;
        int shiftTo = 0;
        while (count < nums.length - 1) {
            shiftTo = (shiftTo + k) % nums.length;
            if (shiftFrom != shiftTo) {
                swap(nums, shiftFrom, shiftTo);
            } else {
                shiftFrom++;
                shiftTo++;
            }
            count++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // approach 2 - Reverse TC: O(n) SC: O(1)
    public void rotate2(int[] nums, int k) {
        // reverse whole array
        reverse(nums, 0, nums.length - 1);

        // reverse the first part and the second part
        reverse(nums, 0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] arr = new int[]{1};
        test.rotate2(arr, 3);
    }
}
