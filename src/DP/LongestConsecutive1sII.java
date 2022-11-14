package DP;

/*
Given an array containing only 0s and 1s and you can change at most one 0 to 1, return the length of the longest subarray of consecutive 1s.

        Example:

        input = [1, 0, 1, 1]

        Output: 4



        Assumptions

        The given array is not null
*/

public class LongestConsecutive1sII {
    // approach 1 - DP TC: O(n) SC: O(n)
    public int longestConsecutiveOnes(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxCounts = new int[nums.length];
        maxCounts[0] = nums[0];
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            // case 1: arr[i] == 1
            // case 2: arr[i] == 0
            maxCounts[i] = nums[i] == 1 ? maxCounts[i - 1] + 1 : 0;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxCounts[i] == i + 1) {
                max = Math.max(max, maxCounts[i]);
            } else {
                int prev = i - maxCounts[i] - 1 >= 0 ? maxCounts[i - maxCounts[i] - 1] : 0;
                max = Math.max(max, maxCounts[i] + prev + 1);
            }
        }
        return max;
    }

    // approach 2 - Sliding window TC: O(n) SC: O(1)
    public int longestConsecutiveOnes2(int[] nums) {
        // edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int count = 0;
        int flip = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            // case 1: arr[i] == 1
            // case 2: arr[i] == 0
            if (nums[i] == 1) {
                count++;
            } else {
                // case 1: 0 flip
                // case 2: 1 flip
                if (flip == 0) {
                    count++;
                    flip++;
                } else {
                    while (nums[start] != 0) {
                        start++;
                    }
                    start++;
                    count = i - start + 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutive1sII test = new LongestConsecutive1sII();
        int[] arr = new int[]{1, 0, 0, 0, 0, 0, 0};
        System.out.println(test.longestConsecutiveOnes2(arr));
    }
}
