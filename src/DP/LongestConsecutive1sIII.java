package DP;

/*
Given an array containing only 0s and 1s and you can change at most k 0s to 1s, return the length of the longest subarray of consecutive 1s.

        Example:

        input = [1, 0, 0, 1, 1, 1, 0, 0]  k = 2

        Output: 6



        Assumptions

        The given array is not null
*/

public class LongestConsecutive1sIII {
    // time complexity: O(n)
    // space complexity: O(1)
    public int longestConsecutiveOnes(int[] nums, int k) {
        int max = 0;
        int count = 0;
        int start = 0;
        int flip = 0;

        for (int i = 0;  i < nums.length; i++) {
            // case 1: arr[i] == 1
            // case 2: arr[i] == 0
            if (nums[i] == 1) {
                count++;
            } else {
                // case 1: flip < k
                // case 2: flip == k
                if (flip < k) {
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
        LongestConsecutive1sIII test = new LongestConsecutive1sIII();
        int[] arr = new int[]{};
        System.out.println(test.longestConsecutiveOnes(arr, 2));
    }
}
