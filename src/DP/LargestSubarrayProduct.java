package DP;

/*
LeetCode 152

Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {2.0, -0.1, 4, -2, -1.5}, the largest subarray product is 4 * (-2) * (-1.5) = 12
*/

public class LargestSubarrayProduct {
//    public double largestProduct(double[] array) {
//        double max = Integer.MIN_VALUE;
//        double curr = 1;
//        double currMin = 1;
//
//        for (int i = 0; i < array.length; i++) {
//            double temp = curr;
//            curr = Math.max(Math.max(curr * array[i], currMin * array[i]), array[i]);
//            currMin = Math.min(Math.min(temp * array[i], currMin * array[i]), array[i]);
//            max = Math.max(max, Math.max(curr, currMin));
//        }
//        return max;
//    }
//
//    // approach 1 - DP TC: O(n) SC: O(1)
//    public int maxProduct(int[] nums) {
//        int max = 1;
//        int min = 1;
//        int globalMax = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            // case 1: max * arr[i]
//            // case 2: min * arr[i]
//            // case 3: arr[i]
//            int temp = max;
//            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
//            min = Math.min(temp * nums[i], Math.min(min * nums[i], nums[i]));
//
//            globalMax = Math.max(globalMax, max);
//        }
//        return globalMax;
//    }

    // approach 1: DP TC: O(n) SC: O(1)
    public int maxProduct(int[] nums) {
        // initialization
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // calculate max and min
            // case 1: max * nums[i]
            // case 2: min * nums[i]
            // case 3: nums[i]
            int temp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(temp * nums[i], Math.min(min * nums[i], nums[i]));

            // update
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestSubarrayProduct test = new LargestSubarrayProduct();
        int[] arr = new int[]{-4, -3, -2};
        System.out.println(test.maxProduct(arr));
    }
}
