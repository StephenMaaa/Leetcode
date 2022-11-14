package String;

/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

        Assumptions

        The string is not null

        The characters used in the original string are guaranteed to be ‘a’ - ‘z’

        There are no adjacent repeated characters with length > 9

        Examples

        “a1c0b2c4” → “abbcccc”
*/

public class DecompressStringII {
    public String decompress(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i + 1 < input.length()) {
            char element = input.charAt(i++);
            int count = Character.getNumericValue(input.charAt(i++));
            for (int j = 0; j < count; j++) {
                sb.append(element);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecompressStringII test = new DecompressStringII();
        System.out.println(test.decompress(""));
    }
}
