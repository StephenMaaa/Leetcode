package DP;

import java.util.Arrays;

public class PackBoxes {
    public int pack(int n) {
        // min arr
        int[] minCount = new int[n + 1];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        for (int i = 1; i < n + 1; i++) {
            // case 1: i can be put in a single box (i is a square of k x k box where i = k^2)
            // case 2: no
            double sqrt = Math.sqrt(i);
            if ((sqrt % 1) == 0) {
                minCount[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    min = Math.min(min, minCount[j] + minCount[i - j]);
                }
                minCount[i] = min;
            }
        }
        return minCount[n];
    }

    public static void main(String[] args) {
        PackBoxes test = new PackBoxes();
        System.out.println(test.pack(10));
    }
}
