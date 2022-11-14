package DP;

/*
There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A. The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.

        Examples

        L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
*/

public class CuttingWood {
    public int minCost(int[] cuts, int length) {
        int[][] minCuts = new int[cuts.length + 2][cuts.length + 2];
        int[] cutArr = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            cutArr[i + 1] = cuts[i];
        }
        cutArr[cutArr.length - 1] = length;

        for (int interval = 2; interval < minCuts.length; interval++) {
            for (int i = 0; i < minCuts.length - interval; i++) {
                int j = i + interval;
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, minCuts[i][k] + minCuts[k][j] + (cutArr[j] - cutArr[i]));
                }
                minCuts[i][j] = min;
            }
        }
        return minCuts[0][minCuts.length - 1];
    }

    public static void main(String[] args) {
        CuttingWood test = new CuttingWood();
        int[] arr = new int[]{};
        System.out.println(test.minCost(arr, 10));
    }
}
