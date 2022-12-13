package Airbnb;

public class WildcardMatching {
    // approach 2 - 2D DP TC: O(mn) SC: O(mn)
    public boolean isMatch(String s, String p) {
        boolean[][] check = new boolean[s.length() + 1][p.length() + 1];
        check[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                check[0][i + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char charB = p.charAt(j);

                // case 1: charB == *
                // case 2: charB == ?
                // case 3: charB == +
                // case 4: otherwise
                if (charB == '*') {
                    check[i + 1][j + 1] = check[i + 1][j] || check[i][j + 1];
                } else if (charB == '+') {
                    check[i + 1][j + 1] = check[i][j] || check[i][j + 1];
                } else if (charB == '?') {
                    check[i + 1][j + 1] = check[i][j];
                } else {
                    check[i + 1][j + 1] = check[i][j] && s.charAt(i) == charB;
                }
            }
        }
        return check[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        System.out.println(test.isMatch("abbbbc", "abb+c"));
    }
}
