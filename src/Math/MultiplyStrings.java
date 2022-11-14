package Math;

/*
Given two numbers represented as strings, return multiplication of the numbers as a string. The numbers can be arbitrarily large and are non-negative.

        Example

        Input: "19", "20"

        Output: "380"
*/

public class MultiplyStrings {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public String multiply(String num1, String num2) {
//        // edge case
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int[] res = new int[num1.length() + num2.length() - 1];
//
//        // calculate
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            for (int j = num2.length() - 1; j >= 0; j--) {
//                res[i + j] += Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
//            }
//        }
//
//        // process
//        int carry = 0;
//        for (int i = res.length - 1; i >= 0; i--) {
//            sb.append((res[i] + carry) % 10);
//            carry = (res[i] + carry) / 10;
//        }
//
//        // append carry
//        if (carry > 0) {
//            sb.append(carry);
//        }
//        return sb.reverse().toString();
//    }

    // approach 1 - Math TC: O(mn) SC: O(m + n)
    public String multiply(String num1, String num2) {
        // edge case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // multiply
        int[] arr = new int[num1.length() + num2.length() - 1];
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                arr[i + j] += (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
            }
        }

        // process
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            sb.append(arr[i] % 10);
        }

        // add carry
        sb.append(arr[0] % 10);
        if (arr[0] / 10 > 0) {
            sb.append(arr[0] / 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings test = new MultiplyStrings();
        System.out.println(test.multiply("99", "2"));
    }
}
