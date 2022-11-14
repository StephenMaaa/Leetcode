package HashTable;

/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

        Assumptions

        The given array is not null and has length of at least 4
        Examples

        A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

        A = {1, 2, 2, 3, 4}, target = 12, return false
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public boolean exist(int[] array, int target) {
        // sort
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            // case: duplicate
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int threeSum = target - array[i];
            // three sum
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = array.length - 1;
                int twoSum = threeSum - array[j];
                // two sum
                while (left < right) {
                    if (left > j + 1 && array[left] == array[left + 1]) {
                        left++;
                        continue;
                    }

                    if (array[left] + array[right] == twoSum) {
                        return true;
                    } else if (array[left] + array[right] < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] arr = new int[]{1, 2, 2, 2, 2, 2};
        System.out.println(test.exist(arr, 8));
    }
}
