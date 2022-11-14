package DP;

/*
Given an unsorted array of doubles, find the subsequence that has the greatest product. Return the product.

        Assumptions

        The given array is not null and has length of at least 1.
*/

public class LargestSubsequenceProduct {
    public double largestProduct(double[] array) {
        double[] maxArr = new double[array.length];
        double[] minArr = new double[array.length];
        maxArr[0] = array[0];
        minArr[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            // case 1: arr[i] >= 0
            // case 2: arr[i] < 0
            if (array[i] >= 0) {
                maxArr[i] = Math.max(maxArr[i - 1], maxArr[i - 1] * array[i]);
                minArr[i] = Math.min(minArr[i - 1], minArr[i - 1] * array[i]);
            } else {
                maxArr[i] = Math.max(maxArr[i - 1], minArr[i - 1] * array[i]);
                minArr[i] = Math.min(minArr[i - 1], maxArr[i - 1] * array[i]);
            }
        }
        return maxArr[array.length - 1];
    }

    public static void main(String[] args) {
        LargestSubsequenceProduct test = new LargestSubsequenceProduct();
        double[] arr = new double[]{2.0, 0.01};
        System.out.println(test.largestProduct(arr));
    }
}
