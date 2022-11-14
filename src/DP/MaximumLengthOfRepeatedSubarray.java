package DP;

/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.



        Example 1:

        Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        Output: 3
        Explanation: The repeated subarray with maximum length is [3,2,1].
        Example 2:

        Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
        Output: 5
*/

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {
    // approach 1 - 2D DP TC: O(mn) SC: O(mn)
    public int findLength(int[] nums1, int[] nums2) {
        int[][] maxCounts = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    maxCounts[i + 1][j + 1] = maxCounts[i][j] + 1;

                    // update max
                    max = Math.max(max, maxCounts[i + 1][j + 1]);
                }
            }
        }
        return max;
    }

    // approach 2 - DP TC: O(mn) SC: O(n)
    public int findLength2(int[] nums1, int[] nums2) {
        int[] maxCountA = new int[nums2.length + 1];
        int[] maxCountB = new int[nums2.length + 1];
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    maxCountB[j + 1] = maxCountA[j] + 1;

                    // update max
                    max = Math.max(max, maxCountB[j + 1]);
                } else {
                    maxCountB[j + 1] = 0;
                }
            }

            for (int k = 0; k < nums2.length; k++) {
                maxCountA[k + 1] = maxCountB[k + 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray test = new MaximumLengthOfRepeatedSubarray();
        int[] arr1 = new int[]{1, 2, 3, 2, 1};
        int[] arr2 = new int[]{3, 2, 1, 4, 7};
        System.out.println(test.findLength2(arr1, arr2));
    }
}
