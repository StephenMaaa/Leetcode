package Array;

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that
        the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
*/

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    // time complexity: O(n)
    // space complexity: O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // edge case
        if (k == 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long bucket = getBucket(nums[i], t + 1);

            // case 1: bucket exists
            // case 2: diff with nearby buckets <= t
            // case 3: otherwise
            if (map.containsKey(bucket)) {
                return true;
            } else if (map.containsKey(bucket - 1) && Math.abs((long) nums[i] - map.get(bucket - 1)) <= t) {
                return true;
            } else if (map.containsKey(bucket + 1) && Math.abs((long) nums[i] - map.get(bucket + 1)) <= t) {
                return true;
            }

            // maintain a sliding window of size k
            if (map.size() >= k) {
                map.remove(getBucket(nums[i - k], t + 1));
            }

            map.put(bucket, (long) nums[i]);
        }
        return false;
    }

    private long getBucket(long num, long k) {
        if (num >= 0) {
            return num / k;
        } else {
            return (num + 1) / k - 1;
        }
    }

    public static void main(String[] args) {
        ContainsDuplicateIII test = new ContainsDuplicateIII();
        int[] arr = new int[]{91, 10, 77, 60, 73, 54, 39, 11, 35};
        System.out.println(test.containsNearbyAlmostDuplicate(arr, 0, 9));
    }
}
