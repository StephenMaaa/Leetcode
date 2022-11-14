package Recursion;

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

        countAndSay(1) = "1"
        countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
        To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
*/

public class CountAndSay {
    // approach 1 - Recursion TC: O(kn) SC: O(kn)
    public String countAndSay(int n) {
        return recursion(new StringBuilder("1"), n - 1);
    }

    private String recursion(StringBuilder str, int n) {
        // base case
        if (n == 0) {
            return str.toString();
        }

        // recursive case
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            // read # of digits
            int count = i;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
            }
            sb.append(i - count + 1);
            sb.append(str.charAt(i));

            i++;
        }
        return recursion(sb, n - 1);
    }

    // approach 2 - Iteration TC: O(kn) SC: O(kn)
    public String countAndSay2(int n) {
        StringBuilder str = new StringBuilder("1");
        StringBuilder sb = new StringBuilder();

        // base case
        if (n == 1) {
            return str.toString();
        }

        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            int j = 0;
            while (j < str.length()) {
                // read # of digits
                int count = j;
                while (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
                    j++;
                }
                sb.append(j - count + 1);
                sb.append(str.charAt(j));

                j++;
            }

            str = sb;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay2(5));
    }
}
