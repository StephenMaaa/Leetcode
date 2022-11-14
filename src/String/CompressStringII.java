package String;

/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.

        Assumptions

        The string is not null

        The characters used in the original string are guaranteed to be ‘a’ - ‘z’

        Examples

        “abbcccdeee” → “a1b2c3d1e3”
*/

public class CompressStringII {
    public String compress(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int count = 1;
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                count++;
            }

            sb.append(input.charAt(i));
            sb.append(count);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CompressStringII test = new CompressStringII();
        System.out.println(test.compress("a"));
    }
}
