package HashTable;

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that
        nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    // time complexity: O(n)
    // space complexity: O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> dup = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // case 1: dup
            // case 2: otherwise
            if (dup.contains(nums[i])) {
                return true;
            }

            // maintain a sliding window of size k
            dup.add(nums[i]);
            if (dup.size() > k) {
                dup.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII test = new ContainsDuplicateII();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8};
        System.out.println(test.containsNearbyDuplicate(arr, 1));
    }
}
