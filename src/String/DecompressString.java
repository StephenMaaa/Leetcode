package String;

/*
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. If the character does not have any adjacent repeated occurrences, it is not compressed.

        Assumptions

        The string is not null

        The characters used in the original string are guaranteed to be ‘a’ - ‘z’

        There are no adjacent repeated characters with length > 9

        Examples

        “acb2c4” → “acbbcccc”
*/

public class DecompressString {
    // approach 1: StringBuilder
    public String decompress(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            // case 1: str[i] == num
            // case 2: otherwise
            if (Character.isDigit(input.charAt(i))) {
                for (int j = 0; j < Character.getNumericValue(input.charAt(i)) - 1; j++) {
                    sb.append(input.charAt(i - 1));
                }
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    // approach 2: in-place
    public String decompress2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                count += Character.getNumericValue(input.charAt(i)) - 2;
            }
        }

        char[] arr = new char[input.length() + count];
        int pointer = 0;
        for (int i = 0; i < input.length(); i++) {
            // case 1: str[i] == num
            // case 2: otherwise
            if (Character.isDigit(input.charAt(i))) {
                for (int j = 0; j < Character.getNumericValue(input.charAt(i)) - 1; j++) {
                    arr[pointer++] = input.charAt(i - 1);
                }
            } else {
                arr[pointer++] = input.charAt(i);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        DecompressString test = new DecompressString();
        System.out.println(test.decompress2(""));
    }
}
