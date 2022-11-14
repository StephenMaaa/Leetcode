package DP;

/*
A message containing letters from A-Z is being encoded to numbers using the following ways:

        ‘A’ = 1

        ‘B’ = 2

        …

        ‘Z’ = 26

        Given an encoded message containing digits, determine the total number of ways to decode it.

        Input:    “212”

        It can be either decoded as 2,1,2("BAB") or 2,12("BL") or 21,2("UB"), return 3.
*/

public class DecodeWays {
    // approach 1: space complexity O(n)
    public int numDecodeWay(String input) {
        // edge case
        if (input == null || input.length() == 0 || input.charAt(0) == '0') {
            return 0;
        }

        int[] counts = new int[input.length()];
        counts[0] = 1;
        for (int i = 1; i < input.length(); i++) {
            // check single digit appending to the tail
            if (input.charAt(i) != '0') {
                counts[i] += counts[i - 1];
            }

            // check two combined digits appending to the tail
            // M[i - 1]: # of decoded ways without combined digits at tail
            // M[i - 2]: # of decoded ways with combined digits at tail
            String combined = input.substring(i - 1, i + 1);
            if (Integer.valueOf(combined) >= 10 && Integer.valueOf(combined) <= 26) {
                if (i == 1) {
                    counts[i] += 1;
                } else {
                    counts[i] += counts[i - 2];
                }
            }
        }
        return counts[input.length() - 1];
    }

    // approach 2: space complexity O(1)
    public int numDecodeWay2(String input) {
        // edge case
        if (input == null || input.length() == 0 || input.charAt(0) == '0') {
            return 0;
        }

        int countA = 0;
        int countB = 1;
        for (int i = 1; i < input.length(); i++) {
            int countC = 0;
            // check single digit appending to the tail
            if (input.charAt(i) != '0') {
                countC += countB;
            }

            // check two combined digits appending to the tail
            // M[i - 1]: # of decoded ways without combined digits at tail
            // M[i - 2]: # of decoded ways with combined digits at tail
            String combined = input.substring(i - 1, i + 1);
            if (Integer.valueOf(combined) >= 10 && Integer.valueOf(combined) <= 26) {
                if (i == 1) {
                    countC += 1;
                } else {
                    countC += countA;
                }
            }
            countA = countB;
            countB = countC;
        }
        return countB;
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodeWay2("624212641113981521649688221891834112776717328126106"));
    }
}
