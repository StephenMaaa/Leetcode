package DP;

/*
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total. Determine the maximum profit you can make.

        Assumptions

        The give array is not null and is length of at least 2
        Examples

        {2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
*/

public class BuyStockIII {
    // approach 1: O(n) space
//    public int maxProfit(int[] array) {
//        // max profit from day 0 to day i
//        int[] maxA = new int[array.length];
//        // max profit from day i to day end
//        int[] maxB = new int[array.length];
//
//        int min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            maxA[i] = Math.max(maxA[i - 1], array[i] - min);
//            min = Math.min(min, array[i]);
//        }
//
//        int max = array[array.length - 1];
//        for (int i = array.length - 2; i >= 0; i--) {
//            maxB[i] = Math.max(maxB[i + 1], max - array[i]);
//            max = Math.max(max, array[i]);
//        }
//
//        int total = 0;
//        for (int i = 0; i < array.length; i++) {
//            total = Math.max(total, maxA[i] + maxB[i]);
//        }
//        return total;
//    }

    // approach 2: O(1) space
    public int maxProfit(int[] array) {
        int buy1 = array[0];
        int sell1 = 0;
        int buy2 = array[0];
        int sell2 = 0;
        for (int i = 1; i < array.length; i++) {
            // total = MAX((sell2 - buy2) + (sell1 - buy1))
            buy1 = Math.min(buy1, array[i]);
            sell1 = Math.max(sell1, array[i] - buy1);
            buy2 = Math.min(buy2, array[i] - sell1);
            sell2 = Math.max(sell2, array[i] - buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        BuyStockIII test = new BuyStockIII();
        int[] arr = new int[]{1, 1};
        System.out.println(test.maxProfit(arr));
    }
}
