package Array;

/*
Find the pair of elements in a given array that sum to a value that is closest to the given target number. Return the values of the two numbers.

        Assumptions

        The given array is not null and has length of at least 2
        Examples

        A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {
    public List<Integer> closest(int[] array, int target) {
        Arrays.sort(array);
        int pointerA = 0;
        int pointerB = array.length - 1;
        int minDiff = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        while (pointerA < pointerB) {
            int sum = array[pointerA] + array[pointerB];
            if (sum == target) {
                return Arrays.asList(array[pointerA], array[pointerB]);
            } else {
                if (Math.abs(target - sum) < minDiff) {
                    minDiff = Math.abs(target - sum);
                    res = Arrays.asList(array[pointerA], array[pointerB]);
                }

                if (sum < target) {
                    pointerA++;
                } else {
                    pointerB--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumClosest test = new TwoSumClosest();
        int[] arr = new int[]{1, 4, 7, 13};
        System.out.println(test.closest(arr, 7));
    }
}
