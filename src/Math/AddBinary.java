package Math;

/*
Given two binary strings, return their sum (also a binary string).

        Input: a = “11”

        b = “1”

        Output: “100”
*/

public class AddBinary {
//    // time complexity: O(n)
//    // space complexity: O(1)
//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int countA = a.length() - 1;
//        int countB = b.length() - 1;
//        int carry = 0;
//
//        while (countA >= 0 || countB >= 0) {
//            int bitA = 0;
//            int bitB = 0;
//
//            // fill 0
//            if (countA >= 0) {
//                bitA = Character.getNumericValue(a.charAt(countA--));
//            }
//
//            if (countB >= 0) {
//                bitB = Character.getNumericValue(b.charAt(countB--));
//            }
//
//            // case 1: both 1
//            // case 2: single 1
//            // case 3: both 0
//            if (bitA == 1 && bitB == 1) {
//                sb.append(carry);
//                carry = 1;
//            } else if (bitA == 1 || bitB == 1) {
//                sb.append(1 - carry);
//            } else {
//                sb.append(carry);
//                carry = 0;
//            }
//        }
//
//        // append carry
//        if (carry == 1) {
//            sb.append(carry);
//        }
//        return sb.reverse().toString();
//    }

    // approach 1 - Two Pointers TC: O(MAX(m, n)) SC: O(1)
    public String addBinary2(String a, String b) {
        int pointerA = a.length() - 1;
        int pointerB  =b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (pointerA >= 0 || pointerB >= 0) {
            // calculate bit
            int bitA = pointerA >= 0 ? a.charAt(pointerA) - '0' : 0;
            int bitB = pointerB >= 0 ? b.charAt(pointerB) - '0' : 0;
            sb.append((bitA + bitB + carry) % 2);

            // calculate carry
            carry = (bitA + bitB + carry) / 2;
            pointerA--;
            pointerB--;
        }

        // append the carry
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    // approach 1: Two Pointers TC: O(MAX(m, n)) SC: O(1)
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        int carry = 0;

        // add operation
        while (pointerA >= 0 || pointerB >= 0) {
            // retrieve bits
            int bitA = pointerA >= 0 ? a.charAt(pointerA--) - '0' : 0;
            int bitB = pointerB >= 0 ? b.charAt(pointerB--) - '0' : 0;

            int sum = (bitA + bitB + carry) % 2;
            carry = (bitA + bitB + carry) >> 1;
            res.append(sum);
        }

        // check carry
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString(); 
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("11", "1"));
    }
}
