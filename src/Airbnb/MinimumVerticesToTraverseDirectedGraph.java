package Airbnb;

import java.util.*;

public class MinimumVerticesToTraverseDirectedGraph {
    public List<Integer> traverse(int[][] edges, int n) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res.add(i);
                visited.add(i);
                dfs(visited, new HashSet<>(), i, i, map, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Set<Integer> visited, Set<Integer> currVisited, int i, int start, Map<Integer, Set<Integer>> map, Set<Integer> res) {
        visited.add(i);
        currVisited.add(i);

        // expand
        for (int next : map.get(i)) {
            // check cycle
            if (res.contains(next) && next != start) {
                res.remove(next);
            }

            if (!currVisited.contains(next)) {
                dfs(visited, currVisited, next, start, map, res);
            }
        }
    }

    public static void main(String[] args) {
        MinimumVerticesToTraverseDirectedGraph test = new MinimumVerticesToTraverseDirectedGraph();
        int[][] edges = {{2,9},{3,3},{3,5},{3,7},{4,8},{5,8},{6,6},{7,4},{8,7},{9,3},{9,6}};
        List<Integer> result = test.traverse(edges, 10);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
