package String;

/*
You are given a string s consisting only of characters 'a' and 'b'.

        You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

        Return the minimum number of deletions needed to make s balanced.
*/

public class MinimumDeletionsToMakeStringBalanced {
    // approach 1: DP TC: O(n) SC: O(1)
    public int minimumDeletions(String s) {
        int min = 0;
        int countB = 0;
        for (int i = 0; i < s.length(); i++) {
            // case 1: str[i] == 'a'
            // case 2: str[i] == 'b'
            if (s.charAt(i) == 'a') {
                min = Math.min(min + 1, countB);
            } else {
                countB++;
            }
        }
        return min;
    }
}
