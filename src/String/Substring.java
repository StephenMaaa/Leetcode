package String;

/*
Determine if a small string is a substring of another large string.

        Return the index of the first occurrence of the small string in the large string.

        Return -1 if the small string is not a substring of the large string.

        Assumptions

        Both large and small are not null
        If small is empty string, return 0
        Examples

        “ab” is a substring of “bcabc”, return 2
        “bcd” is not a substring of “bcabc”, return -1
        "" is substring of "abc", return 0
*/

public class Substring {
    public int strstr(String large, String small) {
        if (small.length() == 0) return 0;

        for (int i = 0; i < large.length() - small.length() + 1; i++) {
            int j = 0;
            while (j < small.length() && small.charAt(j) == large.charAt(i + j)) {
                j++;
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }

    // approach 1 - Linear Scan + Linear Scan TC: O((m - n) * n) SC: O(1)
    public int strStr(String haystack, String needle) {
        // edge case
        if (needle == null || needle.length() == 0) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int start = 0;
            while (start < needle.length() && haystack.charAt(i + start) == needle.charAt(start)) {
                start++;
            }
            if (start == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    // approach 2 - KMP TC: O(m + n) SC: O(1)
    public int strStr2(String haystack, String needle) {
        // edge case
        if (needle == null || needle.length() == 0) {
            return -1;
        }

        int[] lps = new int[needle.length()];

        // implement lps
        for (int i = 1, len = 0; i < needle.length(); i++) {
            // case: str[len] != str[i]
            while (len > 0 && needle.charAt(len) != needle.charAt(i)) {
                len = lps[len - 1];
            }

            // case: str[len] == str[i]
            if (needle.charAt(len) == needle.charAt(i)) {
                len++;
            }
            lps[i] = len;
        }

        // find occurrence
        for (int i = 0, len = 0; i < haystack.length(); i++) {
            // case: str[len] != str[i]
            while (len > 0 && haystack.charAt(i) != needle.charAt(len)) {
                len = lps[len - 1];
            }

            // case: str[len] == str[i]
            if (haystack.charAt(i) == needle.charAt(len)) {
                len++;
            }

            // check
            if (len == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Substring test = new Substring();
        System.out.println(test.strStr2("abbaabbab", "bbab"));
    }
}
