package Math;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

        If the fractional part is repeating, enclose the repeating part in parentheses.

        If multiple answers are possible, return any of them.

        It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FractionToRecurringDecimal {
    // approach 1 - Arrays + Map TC: O(1) SC: O(1)
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        // determine the sign
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append('-');
        }

        // calculate the integer part
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        num %= den;

        // calculate the fraction part
        if (num == 0) {
            return sb.toString();
        }

        Map<Long, Integer> map = new HashMap<>();
        sb.append('.');
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;

            // check recurring part
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(')');
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal test = new FractionToRecurringDecimal();
        System.out.println(test.fractionToDecimal(0, -3));
    }
}
