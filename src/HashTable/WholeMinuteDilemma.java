package HashTable;

/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

        Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
*/

public class WholeMinuteDilemma {
    // approach 1 - Arrays TC: O(n) SC: O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            res += arr[(60 - time[i] % 60) % 60];
            arr[time[i] % 60]++;
        }
        return res;
    }

    public static void main(String[] args) {
        WholeMinuteDilemma test = new WholeMinuteDilemma();
        int[] arr = new int[]{60, 60, 60};
        System.out.println(test.numPairsDivisibleBy60(arr));
    }
}
