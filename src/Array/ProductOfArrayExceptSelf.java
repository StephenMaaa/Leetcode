package Array;

/*
LeetCode 238

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.
*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
//    // approach 1 - prefixSum + suffixSum TC: O(n) SC: O(n)
//    public int[] productExceptSelf(int[] nums) {
//        int[] suffixSum = nums.clone();
//
//        // populate the suffixSum
//        for (int i = suffixSum.length - 2; i >= 0; i--) {
//            suffixSum[i] *= suffixSum[i + 1];
//        }
//
//        // populate the prefixSum
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] *= nums[i - 1];
//        }
//
//        // populate product in-place
//        suffixSum[0] = suffixSum[1];
//        for (int i = 1; i < nums.length - 1; i++) {
//            suffixSum[i] = nums[i - 1] * suffixSum[i + 1];
//        }
//        suffixSum[nums.length - 1] = nums[nums.length - 2];
//        return suffixSum;
//    }

    // approach 2 - prefixSum + suffixSum TC: O(n) SC: O(n)
    public int[] productExceptSelf2(int[] nums) {
        int[] prefixSum = new int[nums.length];

        // populate the prefixSum
        prefixSum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }

        // populate product in-place
        int suffixSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum[i] *= suffixSum;
            suffixSum *= nums[i];
        }
        return prefixSum;
    }

    // approach 1: Prefix Sum TC: O(n) SC: O(n)
    public int[] productExceptSelf(int[] nums) {
        // initialization
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = 1;

        // populate
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] * nums[i - 1];
        }

        int suffixSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefixSum[i] *= suffixSum;
            suffixSum *= nums[i];
        }
        return prefixSum;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(test.productExceptSelf(arr)));
    }
}
