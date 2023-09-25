package HashTable;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

        Each letter in magazine can only be used once in ransomNote.
*/

public class RansomNote {
    // approach 1: map TC: O(n) SC: O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        // counting array
        int[] count = new int[26];
        int[] magaCount = new int[26];

        // update
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            magaCount[c - 'a']++;
        }

        // check
        for (int i = 0; i < count.length; i++) {
            if (count[i] > magaCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote test = new RansomNote();
        System.out.println(test.canConstruct("aa", "ab"));
    }
}
