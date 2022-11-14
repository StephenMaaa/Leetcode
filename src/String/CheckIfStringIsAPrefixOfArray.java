package String;

/*
Given a string s and an array of strings words, determine whether s is a prefix string of words.

        A string s is a prefix string of words if s can be made by concatenating the first k strings in words for some positive k no larger than words.length.

        Return true if s is a prefix string of words, or false otherwise.
*/

public class CheckIfStringIsAPrefixOfArray {
    // approach 1 - Linear Scan TC: O(n) SC: O(1)
    public boolean isPrefixString(String s, String[] words) {
        int count = 0;
        int strCount = 0;
        String str = words[strCount];
        while (count < s.length()) {
            // check in range
            if (count + str.length() > s.length()) {
                return false;
            }

            // check prefix
            for (int i = 0; i < str.length(); i++) {
                if (s.charAt(count) != str.charAt(i)) {
                    return false;
                }
                count++;
            }

            // update
            if (count == s.length()) {
                break;
            }

            // append next string
            if (++strCount >= words.length) {
                return false;
            }
            str = words[strCount];
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfStringIsAPrefixOfArray test = new CheckIfStringIsAPrefixOfArray();
        String[] arr = new String[]{"c", "cc"};
        System.out.println(test.isPrefixString("cccccccc", arr));
    }
}
