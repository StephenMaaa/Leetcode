package DP;

/*
Given an array of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine the minimum number of jumps you need to jump out of the array.

        By jump out, it means you can not stay at the end of the array. Return -1 if you can not do so.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {1, 3, 2, 0, 2}, the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)

        {3, 2, 1, 1, 0}, you are not able to jump out of array, return -1 in this case.
*/

public class ArrayHopperIII {
    public int minJump(int[] array) {
        int[] minArr = new int[array.length];
//        minArr[array.length - 1] = array[array.length - 1] > 0 ? 1 : Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] + i >= array.length) {
                minArr[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = array[i]; j >= 1; j--) {
                    if (minArr[i + j] != Integer.MAX_VALUE) {
                        min = Math.min(min, minArr[i + j] + 1);
                    }
                }
                minArr[i] = min;
            }
        }
        return minArr[0] < Integer.MAX_VALUE ? minArr[0] : -1;
    }

    public static void main(String[] args) {
        ArrayHopperIII test = new ArrayHopperIII();
        int[] arr = new int[]{0};
        System.out.println(test.minJump(arr));
    }
}
