package Array;

/*
Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.

        Assumptions

        The given array is not null and has length of at least 2
        Examples

        A = {1, 2, 2, 4, 7}, target = 7, number of pairs is 6({1,2}, {1, 2}, {1, 4}, {2, 2}, {2, 4}, {2, 4})
*/

import java.util.Arrays;

public class TwoSumSmaller {
    // time complexity: O(n)
    // space complexity: O(1)
    public int smallerPairs(int[] array, int target) {
        Arrays.sort(array);
        int pointerA = 0;
        int pointerB = array.length - 1;
        int count = 0;
        while (pointerA < pointerB) {
            // case 1: sum < target
            // case 2: otherwise
            int sum = array[pointerA] + array[pointerB];
            if (sum < target) {
                count += pointerB - pointerA;
                pointerA++;
            } else {
                pointerB--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumSmaller test = new TwoSumSmaller();
        int[] arr = new int[]{1, 2, 2, 4, 7};
        System.out.println(test.smallerPairs(arr, 7));
    }
}
