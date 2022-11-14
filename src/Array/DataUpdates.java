package Array;

import java.util.Arrays;

public class DataUpdates {
    public int[] dataUpdates(int[] arr, int[][] updates) {
        int[] countArr = new int[arr.length];
        for (int[] update : updates) {
            countArr[update[0] - 1]++;

            if (update[1] < arr.length) {
                countArr[update[1]]--;
            }
        }

        // process
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += countArr[i];
            if (count % 2 == 1) {
                arr[i] = -arr[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DataUpdates test = new DataUpdates();
        int[] arr = new int[]{1, -4, -5, 2};
        int[][] updates = new int[][]{{2, 4}, {1, 2}};
        System.out.println(Arrays.toString(test.dataUpdates(arr, updates)));
    }
}
