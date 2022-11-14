package DP;

/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

        {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
*/

public class ArrayHopperII {
//    public int minJump(int[] array) {
//        int[] minArr = new int[array.length];
//        for (int i = 1; i < array.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (minArr[j] != Integer.MAX_VALUE && array[j] + j >= i) {
//                    min = Math.min(min, minArr[j] + 1);
//                }
//            }
//            minArr[i] = min;
//        }
//        return minArr[array.length - 1] < Integer.MAX_VALUE ? minArr[array.length - 1] : -1;
//    }

//    public int minJump(int[] array) {
//        int[] minArr = new int[array.length];
//        for (int i = 1; i < array.length; i++) {
//            minArr[i] = -1;
//            for (int j = 0; j < i; j++) {
//                if (minArr[j] != -1 && array[j] + j >= i) {
//                    if (minArr[i] == -1 || minArr[i] > minArr[j] + 1) {
//                        minArr[i] = minArr[j] + 1;
//                    }
//                }
//            }
//        }
//        return minArr[array.length - 1];
//    }

    public int minJump(int[] array) {
        int[] minArr = new int[array.length];
        minArr[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] + i >= array.length - 1) {
                minArr[i] = 1;
            } else {
                minArr[i] = -1;
                for (int j = array[i]; j >= 1; j--) {
                    if (minArr[i + j] != -1) {
                        if (minArr[i] == -1 || minArr[i] > minArr[i + j] + 1) {
                            minArr[i] = minArr[i + j] + 1;
                        }
                    }
                }
            }
        }
        return minArr[0];
    }

    // approach 2 - DP/Greedy TC: O(n) SC: O(1)
    public int jump(int[] nums) {
        int minJump = 0;
        int bound = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // invalid case
            if (max < i) {
                return -1;
            }

            max = Math.max(max, i + nums[i]);

            // update
            if (i == bound) {
                bound = max;
                minJump++;
            }
        }
        return minJump - 1;
    }

    public static void main(String[] args) {
        ArrayHopperII test = new ArrayHopperII();
        int[] arr = new int[]{2, 3, 1, 1, 4};
        System.out.println(test.jump(arr));
    }
}
