package Array;

/*
LeetCode 31

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

        For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
        The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

        For example, the next permutation of arr = [1,2,3] is [1,3,2].
        Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
        While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
        Given an array of integers nums, find the next permutation of nums.

        The replacement must be in place and use only constant extra memory.
*/

public class NextPermutation {
//    // approach 1 - Arrays TC: O(n) SC: O(1)
//    public void nextPermutation(int[] nums) {
//        // find the first fall-down index
//        int index;
//        for (index = nums.length - 2; index >=0; index--) {
//            if (nums[index] < nums[index + 1]) {
//                break;
//            }
//        }
//
//        // swap index with the min greater element
//        if (index >= 0) {
//            int i;
//            for (i = index + 1; i < nums.length; i++) {
//                if (nums[index] >= nums[i]) {
//                    break;
//                }
//            }
//            swap(nums, index, i - 1);
//        }
//
//        // reverse the arr after that fall-down index
//        index++;
//        int end = nums.length - 1;
//        while (index < end) {
//            swap(nums, index++, end--);
//        }
//    }

    // approach 1: Arrays TC: O(n) SC: O(1)
    public void nextPermutation(int[] nums) {
        // find the first descending index
        int index;
        for (index = nums.length - 2; index >= 0; index--) {
            // check
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }

        // swap the first descending index with the next min greater
        if (index >= 0) {
            int i;
            for (i = index + 1; i < nums.length; i++) {
                // check
                if (nums[index] >= nums[i]) {
                    break;
                }
            }
            swap(nums, index, i - 1);
        }

        // swap the rest descending arr to ascending
        index++;
        int end = nums.length - 1;
        while (index < end) {
            swap(nums, index++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation test = new NextPermutation();
        int[] arr = new int[]{1, 5, 1};
        test.nextPermutation(arr);
    }
}
