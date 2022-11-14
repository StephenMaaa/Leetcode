package BinarySearch;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/

import java.util.Arrays;

public class SquaresOfSortedArray {
    // approach 1 - Binary Search + Two Pointers TC: O(n) SC: O(1)
    public int[] sortedSquares(int[] nums) {
        // binary search
        int left = 0;
        int right = nums.length - 1;
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == 0) {
                closest = mid;
                break;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (closest == -1) {
            if (left >= nums.length) {
                closest = right;
            } else if (right < 0) {
                closest = left;
            } else {
                closest = Math.abs(nums[left]) < Math.abs(nums[right]) ? left : right;
            }
        }

        // two pointers
        int[] res = new int[nums.length];
        res[0] = nums[closest] * nums[closest];
        left = closest - 1;
        right = closest + 1;
        for (int i = 1; i < nums.length; i++) {
            // case 1: left < 0
            // case 2: right >= len
            // case 3: in range
            if (left < 0) {
                res[i] = nums[right] * nums[right];
                right++;
            } else if (right >= nums.length) {
                res[i] = nums[left] * nums[left];
                left--;
            } else {
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    res[i] = nums[left] * nums[left];
                    left--;
                } else {
                    res[i] = nums[right] * nums[right];
                    right++;
                }
            }
        }
        return res;
    }

    // approach 2 - Two Pointers TC: O(n) SC: O(1)
    public int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            int s1 = nums[left] * nums[left];
            int s2 = nums[right] * nums[right];

            // case 1: square(arr[left]) < square(arr[right])
            // case 2: otherwise
            if (s1 < s2) {
                res[i--] = s2;
                right--;
            } else {
                res[i--] = s1;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray test = new SquaresOfSortedArray();
        int[] arr = new int[]{-1, 1, 2};
        System.out.println(Arrays.toString(test.sortedSquares2(arr)));
    }
}
