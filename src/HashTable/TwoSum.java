package HashTable;

/*
Determine if there exist two elements in a given array, the sum of which is the given target number.

        Assumptions

        The given array is not null and has length of at least 2
        ​Examples

        A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

        A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

        A = {2, 4, 1}, target = 4, return false
*/

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public boolean existSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                return true;
            }
            set.add(target - array[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(test.existSum(arr, 6));
    }
}
