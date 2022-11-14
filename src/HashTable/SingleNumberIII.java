package HashTable;

/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

        You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*/

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;

public class SingleNumberIII {
    // time complexity: O(n)
    // space complexity: O(1)
    public int[] singleNumber(int[] nums) {
        int res = 0;
        // XOR arr -> s1 ^ s2
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        // RSB
        int RSB = res & (~res + 1);
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((RSB & nums[i]) != 0) {
                s1 ^= nums[i];
            } else {
                s2 ^= nums[i];
            }
        }
        return new int[]{s1, s2};
    }

    public static void main(String[] args) {
        SingleNumberIII test = new SingleNumberIII();
        int[] arr = new int[]{1, 2, 2, 5, 5, 6};
        System.out.println(Arrays.toString(test.singleNumber(arr))); 
    }
}
