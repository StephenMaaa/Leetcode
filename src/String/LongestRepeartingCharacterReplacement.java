package String;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

        Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/

public class LongestRepeartingCharacterReplacement {
//    public int characterReplacement(String s, int k) {
//        int[] freq = new int[26];
//        int start = 0;
//        int max = 0;
//        char maxChar = 0;
//        int maxFreq = 0;
//        int others = 0;
//
//        // maintain a sliding window of maxFreq + k
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            // update frequency
//            freq[c - '0']++;
//
//            // case 1: str[i] == maxChar
//            // case 2: otherwise
//            if (c == maxChar) {
//                maxFreq++;
//            } else {
//                // check new most freq
//                if (freq[c - '0'] > maxFreq) {
//                    others = others - freq[c - '0'] + maxFreq + 1;
//                    maxFreq = freq[c - '0'];
//                    maxChar = c;
//                } else {
//                    others++;
//                }
//
//                // check sliding window's size
//                // case 1: k >= others
//                // case 2: otherwise
//                if (k >= others) {
//                    continue;
//                } else {
//                    // maintain sliding window by shrinking the start until k == others
//                    while (k < others) {
//                        // remove
//                        freq[s.charAt(start++) - '0']--;
//
//                        for (int j = 0; j < freq.length; j++) {
//                            maxFreq = Math.max(maxFreq, freq[i]);
//                        }
//                        others = i - start + 1 - maxFreq;
//                    }
//                }
//            }
//        }
//    }

    // approach 1 - Sliding Window TC: O(n) SC: O(1)
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int max = 0;
        int maxFreq = 0;

        // maintain a sliding window of maxFreq + k
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // update frequency
            freq[c - 'A']++;

            // get max freq
            maxFreq = 0;
            for (int j = 0; j < freq.length; j++) {
                maxFreq = Math.max(maxFreq, freq[j]);
            }

            // maintain sliding window by shrinking the start until k == others
            while (k < i - start + 1 - maxFreq) {
                // remove
                freq[s.charAt(start++) - 'A']--;
                maxFreq = 0;
                for (int j = 0; j < freq.length; j++) {
                    maxFreq = Math.max(maxFreq, freq[j]);
                }
            }

            // update max
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestRepeartingCharacterReplacement test = new LongestRepeartingCharacterReplacement();
        System.out.println(test.characterReplacement("ABAA", 0));
    }
}
