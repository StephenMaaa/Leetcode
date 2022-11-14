package Array;

/*
Given two arrays A and B, determine whether or not there exists a pair of elements, one drawn from each array, that sums to the given target number.

        Assumptions

        The two given arrays are not null and have length of at least 1
        Examples

        A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)

        A = {1, 3, 5}, B = {2, 8}, target = 6, return false
*/

import java.util.Arrays;

public class TwoSumTwoArrays {
    // time complexity: O(MAX(nlogn, mlogm))
    // space complexity: O(logn + logm)
    public boolean existSum(int[] a, int[] b, int target) {
        Arrays.sort(a);
        Arrays.sort(b);
        int pointerA = 0;
        int pointerB = b.length - 1;
        while (pointerA < a.length && pointerB >= 0) {
            int sum = a[pointerA] + b[pointerB];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                pointerA++;
            } else {
                pointerB--;
            }
        }
        return false;
    }

    public int countSum(int[] num1, int[] num2, int target) {
        int count = 0;
        int left = 0;
        int right = num2.length - 1;
        while (left < num1.length && right >= 0) {
            long sum = num1[left] + num2[right];

            if (sum == target) {
                int dup = 1;
                while (left < num1.length - 1 && num1[left] == num1[left + 1]) {
                    dup++;
                    left++;
                }

                while (right > 0 && num2[right] == num2[right - 1]) {
                    count += dup;
                    right--;
                }

                count += dup;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumTwoArrays test = new TwoSumTwoArrays();
        int[] a = new int[]{1, 1};
        int[] b = new int[]{2, 2};
        System.out.println(test.countSum(a, b, 3));
    }
}
