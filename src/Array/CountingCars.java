package Array;

import java.util.Arrays;

public class CountingCars {
    public int[] countingCars(int[] numCars, int[] query) {
        int[] maxArr = new int[numCars.length];
        int max = 0;
        int maxCount = 0;
        for (int i = numCars.length - 1; i >= 0; i--) {
            if (max == numCars[i]) {
                maxCount++;
            } else if (max < numCars[i]) {
                max = numCars[i];
                maxCount = 1;
            }

            maxArr[i] = maxCount;
        }

        // process
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            res[i] = maxArr[query[i] - 1];
        }
        return res; 
    }

    public static void main(String[] args) {
        CountingCars test = new CountingCars();
        int[] arr = new int[]{5, 4, 5, 3, 2};
        int[] query = new int[]{1, 2, 4, 5};
        System.out.println(Arrays.toString(test.countingCars(arr, query)));
    }
}
