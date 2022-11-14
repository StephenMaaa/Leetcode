package BFS;

/*
Given eight cards with number 0, 1, 2, ..7 on them, the cards are placed in two rows with 4 cards in each row. In each step only card 0 could swap with one of its adjacent(top, right, bottom, left) card. Your goal is to make all cards placed in order like this:

        0 1 2 3

        4 5 6 7

        Find the minimum number of steps from the given state to the final state. If there is no way to the final state, then return -1.

        The state of cards is represented by an array of integer, for example [0,1,2,3,4,5,6,7] where the first four numbers are in the first row from left to right while the others are placed in the second row from left to right.

        Example:

        Input: [4,1,2,3,5,0,6,7]       Output: 2

        Explanation:

        Initial state is:

        4 1 2 3

        5 0 6 7

        First swap 0 with 5, then the state is:

        4 1 2 3

        0 5 6 7

        Then swap 0 with 4, then we get the final state:

        0 1 2 3

        4 5 6 7
*/

import java.util.*;

public class SevenPuzzle {
    public class State {
        public int num;
        public int zeroLoc;

        public int[] values;

        public State(int[] values) {
            this.num = 0;
            this.values = values;
            for (int i = 0;  i < values.length; i++) {
                this.num = this.num * 10 + values[i];
                if (values[i] == 0) {
                    this.zeroLoc = i;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o instanceof State) {
                State s = (State) o;
                return this.num == s.num;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return num;
        }
    }

    public int numOfSteps(int[] values) {
        State initialState = new State(values);
        List<State> levels = new ArrayList<>();
        levels.add(initialState);
        Set<State> visited = new HashSet<>();
        visited.add(initialState);

        int level = 0;
        // BFS
        while (!levels.isEmpty()) {
            List<State> nextLevel = new ArrayList<>();

            // expand the current level
            for (State state : levels) {
                // terminating case
                if (state.num == 1234567) {
                    return level;
                }

                // expand the next level
                for (State nextState : expandState(state)) {
                    if (!visited.contains(nextState)) {
                        nextLevel.add(nextState);
                        visited.add(nextState);
                    }
                }
            }

            level++;
            levels = nextLevel;
        }
        return -1;
    }

    private List<State> expandState(State state) {
        List<State> expandedStates = new ArrayList<>();
        int[] directionX = new int[]{0, 1, 0, -1};
        int[] directionY = new int[]{-1, 0, 1, 0};

        int y = state.zeroLoc / 4;
        int x = state.zeroLoc % 4;

        // expand four directions
        for (int i = 0; i < directionX.length; i++) {
            int newX = x + directionX[i];
            int newY = y + directionY[i];

            if (newX >= 0 && newX < 4 && newY >= 0 && newY < 2) {
                int[] newValues = Arrays.copyOf(state.values, state.values.length);
                swap(newValues, state.zeroLoc, newY * 4 + newX);
                expandedStates.add(new State(newValues));
            }
        }
        return expandedStates;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
