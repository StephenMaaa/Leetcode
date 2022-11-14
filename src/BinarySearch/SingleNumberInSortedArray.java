package BinarySearch;

/*
Given a sorted integer array. Each integer appears twice except one single element appearing only once. Find this single integer.

        Example 1:

        Input: [1,1,2,2,3,3,4,5,5]
        Output: 4
        Example 2:

        Input: [5,5,6,7,7,8,8]
        Output: 6
        Assumption:The input array is not null and not empty.

        Note:Try to do it in Olog(n) time.
*/

public class SingleNumberInSortedArray {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int getSingleElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid - 1] == arr[mid] -> right-hand side unbalanced
            // case 2: arr[mid] == arr[mid + 1] -> left-hand side unbalanced
            // case 3: otherwise
            if (mid > 0 && nums[mid - 1] == nums[mid]) {
                if (mid % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        SingleNumberInSortedArray test = new SingleNumberInSortedArray();
        int[] arr = new int[]{6};
        System.out.println(test.getSingleElement(arr));
    }
}
