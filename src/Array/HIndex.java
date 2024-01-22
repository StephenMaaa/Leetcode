package Array;

/*
LeetCode 274

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

        According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
*/

public class HIndex {
    // approach 1: PrefixSum TC: O(n) SC: O(m)
    public int hIndex(int[] citations) {
        // get max
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(citations[i], max);
        }

        // create count arr (res)
        int[] count = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            count[max - citations[i]]++;
        }

        // create a prefixSum arr
        int prefixSum = 0;
        for (int i = 0; i < count.length; i++) {
            prefixSum += count[i];

            // check H-index
            if (prefixSum >= max - i) {
                return max - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] arr = new int[]{3, 0, 6, 1, 5};
        System.out.println(test.hIndex(arr));
    }
}
