package Math;

/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
*/

public class MaximumProductOfThreeNumbers {
    // approach 1 - Math TC: O(n) SC: O(1)
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // maintain 3 max and 2 min
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            } else if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers test = new MaximumProductOfThreeNumbers();
        int[] arr = new int[]{1, 2, 3, 4, -100, -10};
        System.out.println(test.maximumProduct(arr));
    }
}
