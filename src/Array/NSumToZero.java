package Array;

/*
Given an integer n, return any array containing n unique integers such that they add up to 0.
*/

public class NSumToZero {
    // approach 1 - Arrays TC: O(n) SC: O(n)
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i += 2) {
            res[i] = i + 1;
            res[i + 1] = -i - 1;
        }
        return res; 
    }
}
