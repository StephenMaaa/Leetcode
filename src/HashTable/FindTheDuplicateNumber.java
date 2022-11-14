package HashTable;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

        There is only one repeated number in nums, return this repeated number.

        You must solve the problem without modifying the array nums and uses only constant extra space.
*/

public class FindTheDuplicateNumber {
//    // approach 1 - Bit Operation TC: O(n) SC: O(1)
//    public int findDuplicate(int[] nums) {
//        int xor = 0;
//        for (int i = 0; i < nums.length; i++) {
//            xor ^= nums[i] ^ i;
//        }
//        return xor;
//    }

//    // approach 2 - Swap TC: O(n) SC: O(1)
//    public int findDuplicate(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != nums[nums[i] - 1]) {
//                swap(nums, i, nums[i] - 1);
//            }
//
//            // check
//            if (i != nums[i] - 1 && nums[i] == nums[nums[i] - 1]) {
//                res = nums[i];
//                break;
//            }
//        }
//        return res;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    // approach 3 - Two Pointers TC: O(n) SC: O(1)
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // check start
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber test = new FindTheDuplicateNumber();
        int[] arr = new int[]{3, 1, 3, 4, 2};
        System.out.println(test.findDuplicate(arr));
    }
}
