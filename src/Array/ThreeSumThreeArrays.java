package Array;

/*
Given three arrays, determine if a set can be made by picking one element from each array that sums to the given target number.

        Assumptions

        The three given arrays are not null and have length of at least 1
        Examples

        A = {1, 3, 5}, B = {8, 2}, C = {3}, target = 14, return true(pick 3 from A, pick 8 from B and pick 3 from C)
*/

import java.util.Arrays;

public class ThreeSumThreeArrays {
    // time complexity: O(m(n + k))
    // space complexity: O(logm + logn + logk)
    public boolean exist(int[] a, int[] b, int[] c, int target) {
        // sort three arrays
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        // three sum = one + twoSum
        for (int i = 0; i < a.length; i++) {
            int twoSum = target - a[i];

            // find twoSum
            int pointerA = 0;
            int pointerB = c.length - 1;
            while (pointerA < b.length && pointerB >= 0) {
                int sum = b[pointerA] + c[pointerB];
                if (sum == twoSum) {
                    return true;
                } else if (sum < twoSum) {
                    pointerA++;
                } else {
                    pointerB--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeSumThreeArrays test = new ThreeSumThreeArrays();
        int[] a = new int[]{3, 1, 5};
        int[] b = new int[]{2, 8};
        int[] c = new int[]{3};
        System.out.println(test.exist(a, b, c, 14));
    }
}
