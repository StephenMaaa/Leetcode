package Airbnb;

import java.util.Arrays;
import java.util.Random;

public class FindMedianInLargeFileOfIntegers {
    // approach 1 - Binary Search + Linear Scan TC: O(nlogn) SC: O(logn)
    public double findMedian(int[] arr) {
        int len = arr.length;

        if (len % 2 == 0) {
            return (findKth(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, len / 2) * 1.0 + findKth(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, len / 2 + 1)) / 2;
        } else {
            return findKth(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, len / 2 + 1);
        }
    }

    private long findKth(int[] arr, long left, long right, int k) {
        // edge case
        if (left >= right) {
            return left;
        }

        long leftBound = left;
        long mid = left + (right - left) / 2;

        // count
        int count = 0;
        for (int i : arr) {
            if (i <= mid) {
                count++;
                leftBound = Math.max(leftBound, i);
            }
        }

        // case 1: count == k
        // case 2: count < k
        // case 3: count > k
        if (count == k) {
            return leftBound;
        } else if (count < k) {
            return findKth(arr, mid + 1, right, k);
        } else {
            return findKth(arr, left, leftBound, k);
        }
    }

    public static void main(String[] args) {
        FindMedianInLargeFileOfIntegers test = new FindMedianInLargeFileOfIntegers();

        int[] nums = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int num = rand.nextInt(100);
            nums[i] = num;
        }
        Arrays.sort(nums);
        for (int i = 0; i < 100; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        System.out.println(nums[49]);
        System.out.println(nums[50]);
        System.out.println(test.findMedian(nums));
    }
}
