package Graph;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

        Return the number of connected components in the graph.
*/

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];

        // initialization
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // union find
        for (int[] edge : edges) {
            combine(parent, size, edge[0], edge[1]);
        }

        // find max
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, size[i]);
        }
        return max;
    }

    private void combine(int[] parent, int[] size, int u, int v) {
        u = find(parent, u);
        v = find(parent, v);

        // combine
        if (u == v) {
            return;
        } else {
            if (size[u] > size[v]) {
                size[u] += size[v];
                parent[v] = u;
            } else {
                size[v] += size[u];
                parent[u] = v;
            }
        }
    }

    private int find(int[] parent, int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(parent, parent[u]);
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph test = new NumberOfConnectedComponentsInAnUndirectedGraph();
        int[][] edges = new int[][]{{0, 1}, {2, 0}, {3, 4}}; 
        System.out.println(test.countComponents(5, edges));
    }
}
