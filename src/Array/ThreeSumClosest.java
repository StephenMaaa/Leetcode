package Array;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the difference  between the sum of the three integers and the given number. You may assume that each input would have exactly one solution.

        Example

        For example, given array S = {-1 2 1 -4}, and target = 1.

        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2) and the difference is 1.
*/

import java.util.Arrays;

public class ThreeSumClosest {
//    // time complexity: O(n^2)
//    // space complexity: O(1)
//    public int threeSumClosest(int[] num, int target) {
//        // sort
//        Arrays.sort(num);
//
//        int minDiff = Integer.MAX_VALUE;
//        for (int i = 0; i < num.length - 2; i++) {
//            int remain = target - num[i];
//
//            // 2 sum closest
//            int left = i + 1;
//            int right = num.length - 1;
//            while (left < right) {
//                int sum = num[left] + num[right];
//
//                // update minDiff
//                minDiff = Math.min(minDiff, Math.abs(remain - sum));
//
//                // case 1: sum == remain
//                // case 2: sum < remain
//                // case 3: sum > remain
//                if (sum == remain) {
//                    return 0;
//                } else if (sum < remain) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return minDiff;
//    }

    // approach 1 - Sorting + Two Pointers TC: O(n^2) SC: O(logn)
    public int threeSumClosest(int[] nums, int target) {
        // sort
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            // two pointers
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target - sum);

                // update closest
                if (closest > diff) {
                    closest = diff;
                    res = sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] arr = new int[]{0, 0, 0};
        System.out.println(test.threeSumClosest(arr, 1));
    }
}
