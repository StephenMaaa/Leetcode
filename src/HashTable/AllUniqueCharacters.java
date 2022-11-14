package HashTable;

/*
Determine if the characters of a given string are all unique.

        Assumptions

        The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
        The given string is not null.
        Examples

        the characters used in "abcd" are unique
        the characters used in "aba" are not unique
*/

public class AllUniqueCharacters {
    public boolean allUnique(String word) {
        int charOccurrence = 0;
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';

            // check the occurrence
            if ((charOccurrence >> charIndex & 1) == 1) {
                return false;
            }

            // update the occurrence
            charOccurrence |= 1 << charIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        AllUniqueCharacters test = new AllUniqueCharacters();
        System.out.println(test.allUnique(""));
    }
}
