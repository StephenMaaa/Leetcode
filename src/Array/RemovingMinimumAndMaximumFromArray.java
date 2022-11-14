package Array;

/*
You are given a 0-indexed array of distinct integers nums.

        There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

        A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

        Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
*/

public class RemovingMinimumAndMaximumFromArray {
    // approach 1 - Linear Scan TC: O(n) SC: O(1)
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // update max and min
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        // update
        max = Math.max(minIndex, maxIndex);
        min = Math.min(minIndex, maxIndex);
        return Math.min(max + 1, Math.min(nums.length - min, min + nums.length - max + 1));
    }

    public static void main(String[] args) {
        RemovingMinimumAndMaximumFromArray test = new RemovingMinimumAndMaximumFromArray();
        int[] arr = new int[]{1};
        System.out.println(test.minimumDeletions(arr)); 
    }
}
