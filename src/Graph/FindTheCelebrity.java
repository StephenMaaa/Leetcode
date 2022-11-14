package Graph;

/*
Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.

        Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

        You are given a helper function bool knows(a, b) that tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.

        Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
*/

public class FindTheCelebrity {
    boolean knows(int a, int b) {
        return true;
    }

    // approach 1 - Voting TC: O(n) SC: O(1)
    public int findCelebrity(int n) {
        // voting
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // check
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // check candidate
        for (int i = 0; i < n; i++) {
            if (candidate != i && knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}
