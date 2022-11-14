package DP;

/*
Given an encrypted message that contains only digits and character '*' where character '*' could represent any digit from 1 to 9. We want to decode the given message to string of capital letters following the rule that A->1, B->2, C->3....Z->26.

        Count how many ways there are to decode the given message. You could assume that the length of given message is always > 0. The result may be very large, so return the result after mod 10^9 + 7.

        Example 1:

        Input = "0"

        Output = 0

        Explanation: There is no way do decode the given message.

        Example 2:

        Input = "1"

        Output = 1

        Explanation: The given message could only be decoded to "A"

        Example 3:

        Input = "*"

        Output = 9

        Explanation: The given message could be any letter in [A,B,C,D,E,F,G,H,I]

        Example 4:

        Input = "2*"

        Output = 15

        Explanation: 9 + 6 = 15. 21~29 could be decoded as BA, BB, ..., BI, and 21~26 could be decoded as U, V, W, X, Y and Z.
*/

public class DecodeWaysII {
    // approach 1: space complexity O(n)
    public int countWaysToDecode(String message) {
        // edge case
        if (message == null || message.length() == 0 || message.charAt(0) == '0') {
            return 0;
        }

        // initialization
        int[] counts = new int[message.length() + 1];
        counts[0] = 1;
        if (message.charAt(0) == '*') {
            counts[1] = 9;
        } else {
            counts[1] = 1;
        }

        for (int i = 1; i < message.length(); i++) {
            char curr = message.charAt(i);
            char prev = message.charAt(i - 1);

            // check single bit appending to the tail
            if (curr == '*') {
                counts[i + 1] += counts[i] * 9;
            } else if  (curr != '0') {
                counts[i + 1] += counts[i];
            }

            // check two combined digits appending to the tail
            String combined = message.substring(i - 1, i + 1);
            if (curr == '*') {
                if (prev == '1') {
                    counts[i + 1] += counts[i - 1] * 9;
                } else if (prev == '2') {
                    counts[i + 1] += counts[i - 1] * 6;
                } else if (prev == '*') {
                    counts[i + 1] += counts[i - 1] * 15;
                }
            } else {
                if (prev == '*') {
                    if (Character.getNumericValue(curr) <= 6) {
                        counts[i + 1] += counts[i - 1] * 2;
                    } else {
                        counts[i + 1] += counts[i - 1];
                    }
                } else {
                    if (Integer.valueOf(combined) >= 10 && Integer.valueOf(combined) <= 26) {
                        counts[i + 1] += counts[i - 1];
                    }
                }
            }
        }
        return counts[message.length()];
    }

    // approach 2: space complexity O(1)
    public int countWaysToDecode2(String message) {
        // edge case
        if (message == null || message.length() == 0 || message.charAt(0) == '0') {
            return 0;
        }

        // initialization
        int countA = 1;
        int countB;
        if (message.charAt(0) == '*') {
            countB = 9;
        } else {
            countB = 1;
        }

        for (int i = 1; i < message.length(); i++) {
            int countC = 0;
            char curr = message.charAt(i);
            char prev = message.charAt(i - 1);

            // check single bit appending to the tail
            if (curr == '*') {
                countC += countB * 9;
            } else if  (curr != '0') {
                countC += countB;
            }

            // check two combined digits appending to the tail
            String combined = message.substring(i - 1, i + 1);
            if (curr == '*') {
                if (prev == '1') {
                    countC += countA * 9;
                } else if (prev == '2') {
                    countC += countA * 6;
                } else if (prev == '*') {
                    countC += countA * 15;
                }
            } else {
                if (prev == '*') {
                    if (Character.getNumericValue(curr) <= 6) {
                        countC += countA * 2;
                    } else {
                        countC += countA;
                    }
                } else {
                    if (Integer.valueOf(combined) >= 10 && Integer.valueOf(combined) <= 26) {
                        countC += countA;
                    }
                }
            }
            countA = countB;
            countB = countC;
        }
        return countB;
    }

    // approach 1 - DP TC: O(n) SC: O(n)
    public int numDecodings(String s) {
        // edge case
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        long[] counts = new long[s.length() + 1];
        int overflow = (int) Math.pow(10, 9) + 7;
        counts[0] = 1;
        counts[1] = s.charAt(0) > '0' ? 1 : 0;
        counts[1] = s.charAt(0) == '*' ? 9 : counts[0];

        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);

            // add current single digit
            if (curr == '*') {
                counts[i + 1] = 9 * counts[i];
            } else if (curr > '0') {
                counts[i + 1] = counts[i];
            }

            // add two digits
            // case 1: *
            // case 2: 1
            // case 3: 2
            // case 4: otherwise
            if (prev == '*') {
                // case 1: curr == *
                // case 2: curr < 7
                // case 3: otherwise
                if (curr == '*') {
                    counts[i + 1] += 15 * counts[i - 1];
                } else if (curr < '7') {
                    counts[i + 1] += 2 * counts[i - 1];
                } else {
                    counts[i + 1] += counts[i - 1];
                }
            } else if (prev == '1') {
                // case 1: curr == *
                // case 2: otherwise
                if (curr == '*') {
                    counts[i + 1] += 9 * counts[i - 1];
                } else {
                    counts[i + 1] += counts[i - 1];
                }
            } else if (prev == '2') {
                // case 1: curr == *
                // case 2: curr < 7
                if (curr == '*') {
                    counts[i + 1] += 6 * counts[i - 1];
                } else if (curr < '7') {
                    counts[i + 1] += counts[i - 1];
                }
            }

            // check overflow
            if (counts[i + 1] >= overflow) {
                counts[i + 1] %= overflow;
            }
        }
        return (int) counts[s.length()];
    }

    // approach 2 - DP TC: O(n) SC: O(1)
    public int numDecodings2(String message) {
        // edge case
        if (message == null || message.length() == 0 || message.charAt(0) == '0') {
            return 0;
        }

        // initialization
        long countA = 1;
        long countB;
        if (message.charAt(0) == '*') {
            countB = 9;
        } else {
            countB = 1;
        }
        int overflow = (int) Math.pow(10, 9) + 7;

        for (int i = 1; i < message.length(); i++) {
            long countC = 0;
            char prev = message.charAt(i - 1);
            char curr = message.charAt(i);

            // check single bit appending to the tail
            if (curr == '*') {
                countC += countB * 9;
            } else if  (curr != '0') {
                countC += countB;
            }

            // check two combined digits appending to the tail
            if (curr == '*') {
                if (prev == '1') {
                    countC += countA * 9;
                } else if (prev == '2') {
                    countC += countA * 6;
                } else if (prev == '*') {
                    countC += countA * 15;
                }
            } else {
                if (prev == '*') {
                    if (curr < '7') {
                        countC += countA * 2;
                    } else {
                        countC += countA;
                    }
                } else {
                    if (prev == '1' || (prev == '2' && curr < '7')) {
                        countC += countA;
                    }
                }
            }
            countA = countB % overflow;
            countB = countC % overflow;
        }
        return (int) countB;
    }

    public static void main(String[] args) {
        DecodeWaysII test = new DecodeWaysII();
//        System.out.println(test.countWaysToDecode2("2***"));
        System.out.println(test.numDecodings2("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
    }
}
