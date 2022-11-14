package String;

/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class LongestCommonPrefix {
    // time complexity: O(n^2)
    // space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        // edge case
        if (strs == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            char curr = 0;
            for (int i = 0; i < strs.length; i++) {
                // case 1: count >= len
                // case 2: initialization
                // case 3: not match
                if (count >= strs[i].length()) {
                    return sb.toString();
                } else if (i == 0) {
                    curr = strs[i].charAt(count);
                } else if (curr != strs[i].charAt(count)) {
                    return sb.toString();
                }
            }
            sb.append(curr);
            count++;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] arr = new String[]{"abcd", "abcdr", "abcdr", "abcdrf", "abc", "acbc"};
        System.out.println(test.longestCommonPrefix(arr));
    }
}
