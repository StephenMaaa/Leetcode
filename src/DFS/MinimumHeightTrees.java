package DFS;

/*
LeetCode 310

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

        Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

        Return a list of all MHTs' root labels. You can return the answer in any order.

        The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

import java.util.*;

public class MinimumHeightTrees {
    // approach 1: DFS TC: O(n^2) SC: O(n^2)
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        // construct graph
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> res = new ArrayList<>();
        int min = n;
        for (int i = 0; i < n; i++) {
            int depth = getDepth(i, graph);

            // check
            if (depth <= min) {
                // update
                if (depth < min) {
                    min = depth;
                    res = new ArrayList<>();
                }
                res.add(i);
            }
        }
        return res;
    }

    private int getDepth(int root, List<List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        visited.add(root);

        int depth = traverse(root, visited, graph);
        return depth;
    }

    private int traverse(int root, Set<Integer> visited, List<List<Integer>> graph) {
        List<Integer> neighbors = graph.get(root);
        int size = neighbors.size();
        int depth = 0;

        // base case & recursive case
        for (int neighbor : neighbors) {
            // check
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                depth = Math.max(depth, traverse(neighbor, visited, graph));
            }
        }
        return depth + 1;
    }

    // approach 2: Topological Sort TC: O(n) SC: O(n)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // edge case
        if (n == 1) {
            return Arrays.asList(0);
        }

        // construct graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // initialization
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                queue.offer(i);
            }
        }

        // Topological Sort
        int remains = n;
        while (remains > 2) {
            int size = queue.size();
            remains -= size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                int neighbor = graph.get(node).iterator().next();

                // remove current node from neighbors
                Set<Integer> neighbors = graph.get(neighbor);
                neighbors.remove(node);

                // check
                if (neighbors.size() == 1) {
                    queue.offer(neighbor);
                }
            }
        }

        // poll the rest
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumHeightTrees test = new MinimumHeightTrees();
        int[][] edges = new int[][]{{0, 1}, {0, 2}};
        System.out.println(test.findMinHeightTrees(3, edges));
    }
}
