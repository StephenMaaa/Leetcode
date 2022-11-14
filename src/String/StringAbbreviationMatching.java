package String;

/*
Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

        Assumptions:

        The original string only contains alphabetic characters.
        Both input and pattern are not null.
        Pattern would not contain invalid information like "a0a","0".
        Examples:

        pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
*/

public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        int checked = 0;
        int i = 0;
        while (i < pattern.length()) {
            // int
            if (pattern.charAt(i) >= '0' && pattern.charAt(i) <= '9') {
                int count = 0;
                while (i < pattern.length() && pattern.charAt(i) >= '0' && pattern.charAt(i) <= '9') {
                    count = count * 10 + Character.getNumericValue(pattern.charAt(i++));
                }
                checked += count;
                if (checked == 0 || checked > input.length()) {
                    return false;
                }
            } else {
                if (checked < input.length() && input.charAt(checked) != pattern.charAt(i)) {
                    return false;
                }
                checked++;
                i++;
            }
        }
        return checked == input.length() && i == pattern.length();
    }

    public static void main(String[] args) {
        StringAbbreviationMatching test = new StringAbbreviationMatching();
        System.out.println(test.match("apple", "6"));
    }
}
