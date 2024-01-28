package Graph;

/*
LeetCode 399

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

        You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

        Return the answers to all queries. If a single answer cannot be determined, return -1.0.

        Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

        Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
*/

import sun.java2d.windows.GDIRenderer;

import java.util.*;

public class EvaluateDivision {
    // approach 1: Graph + DFS TC: O(kmn) SC: O(kmn)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // initialization
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Double> weights = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            // create bidirectional edges
            if (!graph.containsKey(equation.get(0))) {
                graph.put(equation.get(0), new ArrayList<>());
            }

            if (!graph.containsKey(equation.get(1))) {
                graph.put(equation.get(1), new ArrayList<>());
            }
            graph.get(equation.get(0)).add(equation.get(1));
            graph.get(equation.get(1)).add(equation.get(0));

            // add weights
            weights.put(equation.get(0) + " " + equation.get(1), values[i]);
            weights.put(equation.get(1) + " " + equation.get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);

            // edge case
            if (!graph.containsKey(query.get(0))) {
                continue;
            }
            Set<String> visited = new HashSet<>();
            visited.add(query.get(0));
            dfs(query.get(0), query.get(1), 1, res, i, graph, weights, visited);
        }
        return res;
    }

    private void dfs(String start, String end, double value, double[] res, int index, Map<String, List<String>> graph, Map<String, Double> weights, Set<String> visited) {
        // base case
        if (start.equals(end)) {
            res[index] = value;
            return;
        }

        // recursive case
        // check existence
        if (graph.containsKey(start)) {
            List<String> neighbors = graph.get(start);

            // explore
            for (String neighbor : neighbors) {
                // check valid path
                if (!visited.contains(neighbor)) {
                    value *= weights.get(start + " " + neighbor);
                    visited.add(neighbor);
                    dfs(neighbor, end, value, res, index, graph, weights, visited);
                    value /= weights.get(start + " " + neighbor);
                    visited.remove(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        EvaluateDivision test = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("ab", "c"));
        equations.add(Arrays.asList("a", "bc"));
        double[] values = new double[]{2.0, 3.0, 4.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("ab", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        System.out.println(Arrays.toString(test.calcEquation(equations, values, queries)));
    }
}
