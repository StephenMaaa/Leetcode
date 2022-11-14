package Array;

/*
A split of an integer array is good if:

        The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
        The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.
        Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
*/

public class WaysToSplitArrayIntoThreeSubarrays {
//    // approach 1 - prefixSum TC: O(n^2) SC: O(1)
//    public int waysToSplit(int[] nums) {
//        long sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//
//        // prefixSum
//        long prefixSum = 0;
//        long midSum = 0;
//        int count = 0;
//        int overflow = (int) Math.pow(10, 9) + 7;
//        for (int i = 0; i < nums.length - 2; i++) {
//            prefixSum += nums[i];
//            midSum = 0;
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                midSum += nums[j];
//
//                // check
//                if (prefixSum <= midSum && midSum <= sum - midSum - prefixSum) {
//                    count++;
//
//                    // check overflow
//                    if (count == overflow) {
//                        count = 0;
//                    }
//                }
//            }
//        }
//        return count;
//    }

//    // approach 2 - prefixSum + Binary Search TC: O(nlogn) SC: O(n)
//    public int waysToSplit(int[] nums) {
//        // prefixSum
//        long[] prefixSum = new long[nums.length];
//        prefixSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            prefixSum[i] = prefixSum[i - 1] + nums[i];
//        }
//
//        int count = 0;
//        int overflow = (int) (1e9 + 7);
//        for (int i = 0; i < nums.length - 2; i++) {
//            // binary search
//            // find leftBound
//            int leftBound = 0;
//            int left = i + 1;
//            int right = nums.length - 2;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//
//                // case 1: leftSum <= prefixSum[mid] - leftSum
//                // case 2: otherwise
//                if (prefixSum[i] <= prefixSum[mid] - prefixSum[i]) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            leftBound = left;
//
//            // find rightBound
//            left = leftBound;
//            right = nums.length - 2;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//
//                // case 1: prefixSum[mid] - leftSum <= prefixSum[n - 1] - prefixSum[mid]
//                // case 2: otherwise
//                if (prefixSum[mid] - prefixSum[i] <= prefixSum[nums.length - 1] - prefixSum[mid]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            count += right - leftBound + 1;
//
//            // check overflow
//            if (count >= overflow) {
//                count %= overflow;
//            }
//        }
//        return count;
//    }

    // approach 3 - prefixSum + Two Pointers TC: O(n) SC: O(n)
    public int waysToSplit(int[] nums) {
        // prefixSum
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        int overflow = (int) (1e9 + 7);
        int leftBound = 1;
        int rightBound = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            // find leftBound
            leftBound = Math.max(leftBound, i + 1);
            while (leftBound < nums.length - 1 && prefixSum[i] > prefixSum[leftBound] - prefixSum[i]) {
                leftBound++;
            }

            // find rightBound
            rightBound = Math.max(leftBound, rightBound);
            while (rightBound < nums.length - 1 && prefixSum[rightBound] - prefixSum[i] <= prefixSum[nums.length - 1] - prefixSum[rightBound]) {
                rightBound++;
            }
            count += rightBound - leftBound;

            // check overflow
            if (count >= overflow) {
                count %= overflow;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        WaysToSplitArrayIntoThreeSubarrays test = new WaysToSplitArrayIntoThreeSubarrays();
        int[] arr = new int[]{1, 2, 2, 2, 5, 0};
        System.out.println(test.waysToSplit(arr));
    }
}
