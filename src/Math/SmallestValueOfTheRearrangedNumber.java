package Math;

/*
You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.

        Return the rearranged number with minimal value.

        Note that the sign of the number does not change after rearranging the digits.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestValueOfTheRearrangedNumber {
    // approach 1 - Math TC: O(1) SC: O(1)
    public long smallestNumber(long num) {
        // generate arr
        List<Integer> list = new ArrayList<>();
        boolean sign = num > 0;
        int countZero = 0;
        while (num >= 10 || num <= -10) {
            int digit = (int) (num % 10L);
            if (sign && digit == 0) {
                countZero++;
            }
            list.add(digit);
            num /= 10;
        }

        // add last digit
        int digit = (int) (num % 10L);
        if (sign && digit == 0) {
            countZero++;
        }
        list.add(digit);

        Collections.sort(list);

        long res = 0;
        for (int i = countZero; i < list.size(); i++) {
            res = res * 10 + list.get(i);
            // append leading zero
            if (i == countZero && sign) {
                res *= Math.pow(10, countZero);
            }
        }

        return res;
    }

    // approach 2 - Math TC: O(1) SC: O(1)
    public long smallestNumber2(long num) {
        // generate arr
        int[] freq = new int[10];
        boolean sign = num > 0;
        num = Math.abs(num);
        while (num != 0) {
            freq[(int) (num % 10L)]++;
            num /= 10;
        }


        if (sign) {
            // handle leading zeros
            for (int i = 1; i < freq.length; i++) {
                if (freq[i] > 0) {
                    num = i;
                    freq[i]--;
                    break;
                }
            }

            for (int i = 0; i < freq.length; i++) {
                while (freq[i]-- > 0) {
                    num = num * 10 + i;
                }
            }
        } else {
            for (int i = freq.length - 1; i >= 0; i--) {
                while (freq[i]-- > 0) {
                    num = num * 10 + i;
                }
            }
            num = -num;
        }
        return num;
    }

    public static void main(String[] args) {
        SmallestValueOfTheRearrangedNumber test = new SmallestValueOfTheRearrangedNumber();
        System.out.println(test.smallestNumber(1000000L));
    }
}
