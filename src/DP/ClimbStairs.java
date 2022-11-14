package DP;

/*
There are in total n steps to climb until you can reach the top. You can climb 1 or 2 steps a time. Determine the number of ways you can do that.

        Example:

        Input: n = 4, Return 5.
*/

public class ClimbStairs {
    public int stairs(int n) {
        // edge case
        if (n < 1) {
            return 0;
        }

        int countA = 0;
        int countB = 1;
        for (int i = n; i > 0; i--) {
            int temp = countA;
            countA = countB;
            countB = temp + countB;
        }
        return countB;
    }

    public static void main(String[] args) {
        ClimbStairs test = new ClimbStairs();
        System.out.println(test.stairs(4));
    }
}
