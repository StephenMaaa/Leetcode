package HashTable;

/*
Determine if the characters of a given string are all unique.

        Assumptions

        We are using ASCII charset, the value of valid characters are from 0 to 255
        The given string is not null
        Examples

        all the characters in "abA+\8" are unique
        "abA+\a88" contains duplicate characters
*/

public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        // 8 32-bit ints to store 256 chars (0 - 255)
        int[] charOccurrences = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int intIndex = word.charAt(i) / 32;
            int charIndex = word.charAt(i) % 32;

            // check the occurrence
            if ((charOccurrences[intIndex] >> charIndex & 1) == 1) {
                return false;
            }

            // update the occurrence
            charOccurrences[intIndex] |= 1 << charIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        AllUniqueCharactersII test = new AllUniqueCharactersII();
        System.out.println(test.allUnique("lodqomabca"));
    }
}
