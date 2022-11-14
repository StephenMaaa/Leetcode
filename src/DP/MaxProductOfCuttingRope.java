package DP;

/*
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

        Assumptions

        n >= 2
        Examples

        n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // base case 0, 1, 2
        if (length < 2) {
            return 0;
        }

        int[] maxArr = new int[length + 1];
        maxArr[0] = 0;
        maxArr[1] = 0;
        for (int i = 2; i < length + 1; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j, maxArr[j]) * Math.max(i - j, maxArr[i - j]));
            }
            maxArr[i] = max;
        }
        return maxArr[length];
    }

    public static void main(String[] args) {
        int length = 2;
        MaxProductOfCuttingRope test = new MaxProductOfCuttingRope();
        System.out.println(test.maxProduct(length));
    }
}
