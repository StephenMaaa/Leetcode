package DFS;

/*
Given an integer array A representing a forest, such that, A[i] means the parent index of index i, if A[i] == -1, it means index i is a root.

        Determine what is the depth of the forest, the depth of the forest is the maximum depth of the trees in the forest.

        Examples:

        A = {2, 2, -1, 5, 5, -1, 3}, represnts the forest:

        2

        / \

        0   1

        and

        5

        /  \

        3    4

        /

        6

        The depth of the forest is 3(the depth of the second tree).

        Assumptions:

        The given array is not null or empty, all the elements in the array are in the range of [-1, N - 1] where N is the length of the array.
        Corner Cases:

        You should be able to identify that there could be a cycle in the forest, what if that is the case? Return -1
*/

import java.util.HashSet;
import java.util.Set;

public class DepthOfForest {
    // time complexity: O(n)
    // space complexity: O(n)
    public int depth(int[] forest) {
        int[] depth = new int[forest.length];
        Set<Integer> visited = new HashSet<>();
        boolean[] cycle = new boolean[1];
        for (int i = 0; i < depth.length; i++) {
            if (!cycle[0]) {
                findDepth(forest, depth, i, cycle, visited);
            } else {
                return -1;
            }
        }

        // update max
        int max = 0;
        for (int i = 0; i < depth.length; i++) {
            max = Math.max(max, depth[i]);
        }
        return max;
    }

    private void findDepth(int[] parents, int[] depth, int i, boolean[] cycle, Set<Integer> visited) {
        // edge case
        if (visited.contains(i)) {
            cycle[0] = true;
            return;
        }

        visited.add(i);
        // case 1: node is root
        // case 2: parent's depth unavailable
        // case 3: parent's depth available
        if (parents[i] == -1) {
            depth[i] = 1;
            visited.remove(i);
            return;
        }

        if (depth[parents[i]] == 0) {
            findDepth(parents, depth, parents[i], cycle, visited);
        }

        depth[i] = depth[parents[i]] + 1;
        visited.remove(i);
    }

    public static void main(String[] args) {
        DepthOfForest test = new DepthOfForest();
        int[] arr = new int[]{};
        System.out.println(test.depth(arr));
    }
}
