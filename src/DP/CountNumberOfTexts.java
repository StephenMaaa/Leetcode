package DP;

/*
Alice is texting Bob using her phone. The mapping of digits to letters is shown in the figure below.


        In order to add a letter, Alice has to press the key of the corresponding digit i times, where i is the position of the letter in the key.

        For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
        Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
        However, due to an error in transmission, Bob did not receive Alice's text message but received a string of pressed keys instead.

        For example, when Alice sent the message "bob", Bob received the string "2266622".
        Given a string pressedKeys representing the string received by Bob, return the total number of possible text messages Alice could have sent.

        Since the answer may be very large, return it modulo 10^9 + 7.
*/

public class CountNumberOfTexts {
    // approach 1 - DP TC: O(n) SC: O(n)
    public int countTexts(String pressedKeys) {
        long[] counts = new long[pressedKeys.length()];
        counts[0] = 1;
        int overflow = (int) Math.pow(10, 9) + 7;

        for (int i = 1; i < pressedKeys.length(); i++) {
            char digit = pressedKeys.charAt(i);
            counts[i] = counts[i - 1];
            int range = 3;
            if (digit == '7' || digit == '9') {
                range++;
            }
            counts[i] = counts[i - 1];
            for (int j = 1; j < range; j++) {
                if (i - j >= 0 && pressedKeys.charAt(i - j) == digit) {
                    counts[i] += i - j == 0 ? 1 : counts[i - j - 1];
                } else {
                    break;
                }
            }

            // check overflow
            if (counts[i] >= overflow) {
                counts[i] %= overflow;
            }
        }
        return (int) counts[pressedKeys.length() - 1];
    }

    public static void main(String[] args) {
        CountNumberOfTexts test = new CountNumberOfTexts();
        System.out.println(test.countTexts(
                "444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
    }
}
