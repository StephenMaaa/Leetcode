package DP;

public class BinaryGame {
    public int binaryGame(int min, int max, int zero_group, int one_group) {
        long[] dp = new long[max + 1];

        // initialization
        dp[0] = 1;

        for (int i = 1; i <= max; i++) {
            if (i >= one_group) {
                dp[i] += dp[i - one_group];
            }
            if (i >= zero_group) {
                dp[i] += dp[i - zero_group];
            }
        }

        long res = 0;
        for (int i = min; i <= max; i++) {
            res += dp[i];
        }
        return (int) (res % (1e9 + 7));
    }

    public static void main(String[] args) {
        BinaryGame test = new BinaryGame();
        System.out.println(test.binaryGame(1, 3, 1, 2));
    }
}
