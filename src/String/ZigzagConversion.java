package String;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"
*/

public class ZigzagConversion {
    // approach 1 - Level order traversal TC: O(n) SC: O(1)
    public String convert(String s, int numRows) {
        // edge case
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int start = i;
            int count = 0;

            // populate every row
            while (start < s.length()) {
                sb.append(s.charAt(start));

                // case 1: first/last row
                // case 2: middle rows
                if (i == 0 || i == numRows - 1) {
                    start += 2 * numRows - 2;
                } else {
                    // case 1: down
                    // case 2: up
                    if (count % 2 == 0) {
                        start += 2 * numRows - 2 * i - 2;
                    } else {
                        start += 2 * i;
                    }
                }
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion test = new ZigzagConversion();
        System.out.println(test.convert("A", 1));
    }
}
