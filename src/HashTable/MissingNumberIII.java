package HashTable;

/*
Given an integer array supposedly contains numbers of (1, 2, 3....N) where 2 <= N <= 10000. The numbers are unordered. However there is one number occurs twice so that another number is missing. Return an array these two numbers where the first element is the duplicated number, and the second element is the missing number.

        Example:

        Input = [1, 1, 3, 4]

        Output = [1, 2]
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumberIII {
    // approach 1 - Set TC: O(n) SC: O(n)
    public int[] missingNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                res[0] = nums[i];
            } else {
                set.add(nums[i]);
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    // approach 2 - Bit Operation TC: O(n) SC: O(1)
    public int[] missingNumber2(int[] nums) {
        // find missing ^ dup
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            xor ^= i;
        }

        // find the rightmost set bit
        int rightmost = xor & ~(xor - 1);
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ rightmost) == 0) {
                y ^= nums[i];
            } else {
                x ^= nums[i];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if ((i ^ rightmost) == 0) {
                y ^= i;
            } else {
                x ^= i;
            }
        }
        return new int[]{y, x};
    }

    public static void main(String[] args) {
        MissingNumberIII test = new MissingNumberIII();
        int[] arr = new int[]{53,33,20,43,62,52,1,36,44,5,37,51,56,64,21,6,30,34,19,9,54,24,7,58,11,40,32,45,47,15,61,16,14,25,42,59,46,39,4,60,29,22,17,38,63,50,48,23,10,49,13,27,3,57,28,18,31,55,45,2,35,41,26,8,12};
        System.out.println(Arrays.toString(test.missingNumber2(arr)));
    }
}
