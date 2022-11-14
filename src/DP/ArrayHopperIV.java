package DP;

/*
Given an array A of non-negative integers, you are initially positioned at an arbitrary index of the array. A[i] means the maximum jump distance from that position (you can either jump left or jump right). Determine the minimum jumps you need to reach the right end of the array. Return -1 if you can not reach the right end of the array.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {1, 3, 1, 2, 2}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

        {3, 3, 1, 0, 0}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array)

        {4, 0, 1, 0, 0}, if the initial position is 2, you are not able to reach the right end of array, return -1 in this case.
*/

public class ArrayHopperIV {
    public int minJump(int[] array, int index) {
        if (index > array.length - 1) {
            return -1;
        }

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

        for (int i = 1; i < array.length; i++) {
            for (int j = -array[i]; j < 0; j++) {
                if (i + j >= 0 && minArr[i + j] != -1) {
                    if (minArr[i] == -1 || minArr[i] > minArr[i + j] + 1) {
                        minArr[i] = minArr[i + j] + 1;
                    }
                }
            }
        }
        return minArr[index];
    }

    public static void main(String[] args) {
        ArrayHopperIV test = new ArrayHopperIV();
        int[] arr = new int[]{5,1,1,1,0,4};
        System.out.println(test.minJump(arr, 1));
    }
}
