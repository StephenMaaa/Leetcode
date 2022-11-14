package String;

/*
Determine if two given Strings are one edit distance.

        One edit distance means you can only insert one character/delete one character/replace one character to another character in one of the two given Strings and they will become identical.

        Assumptions:

        The two given Strings are not null
        Examples:

        s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical

        s = "abc", t = "bcd" are not one edit distance
*/

import javax.swing.plaf.basic.BasicDesktopIconUI;

public class OneEditDistance {
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean oneEditDistance(String source, String target) {
        // edge case
        int diff = Math.abs(source.length() - target.length());
        if (diff > 1) {
            return false;
        }

        int pointerA = 0;
        int pointerB = 0;
        boolean edited = false;

        while (pointerA < source.length() || pointerB < target.length()) {
            // edge case
            if (pointerA >= source.length()) {
                return !edited;
            } else if (pointerB >= target.length()) {
                return !edited;
            }

            // case 1: strA[pA] == strB[pB]
            // case 2: otherwise
            if (source.charAt(pointerA) == target.charAt(pointerB)) {
                pointerA++;
                pointerB++;
            } else {
                // case 1: edited
                // case 2: otherwise
                if (edited) {
                    return false;
                } else {
                    // case 1: replace
                    // case 2: insert/delete
                    if (diff == 0) {
                        pointerA++;
                        pointerB++;
                    } else {
                        if (source.length() > target.length()) {
                            pointerA++;
                        } else {
                            pointerB++;
                        }
                    }
                    edited = true;
                }
            }
        }
        return edited;
    }

    public static void main(String[] args) {
        OneEditDistance test = new OneEditDistance();
        System.out.println(test.oneEditDistance("abc", "bcd"));
    }

    // asd: ds, dsa, sa, dsa
}
