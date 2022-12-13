package Airbnb;

/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

        You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/

import java.util.*;

public class CheapestFlightsWithinKStops {
//    // approach 1 - Graph + BFS TC: O(V + E) SC: O(V + E)
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        // build graph
//        Map<Integer, List<int[]>> map = new HashMap<>();
//        for (int[] flight : flights) {
//            if (!map.containsKey(flight[0])) {
//                map.put(flight[0], new ArrayList<>());
//            }
//            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
//        }
//
//        Deque<int[]> queue = new ArrayDeque<>();
//        int minCost = Integer.MAX_VALUE;
//        Map<Integer, Integer> minMap = new HashMap<>();
//        queue.offer(new int[]{src, 0});
//        minMap.put(src, 0);
//
//        // BFS
//        while (!queue.isEmpty() && k >= -1) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int[] entry = queue.poll();
//                // System.out.println(Arrays.toString(entry));
//                // check
//                if (entry[0] == dst) {
//                    minCost = Math.min(minCost, entry[1]);
//                } else if (map.containsKey(entry[0])) {
//                    for (int[] flight : map.get(entry[0])) {
//                        if (!minMap.containsKey(flight[0]) || minMap.get(flight[0]) >= entry[1] + flight[1]) {
//                            minMap.put(flight[0], entry[1] + flight[1]);
//                            queue.offer(new int[]{flight[0], entry[1] + flight[1]});
//                        }
//                    }
//                }
//            }
//            k--;
//        }
//        return minCost == Integer.MAX_VALUE ? -1 : minCost;
//    }

//    // approach 2 - Dijikstra Algorithm TC: O(V^2logV) SC: O(V^2)
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        // build adjacency matrix
//        int[][] matrix = new int[n][n];
//        for (int[] flight : flights) {
//            matrix[flight[0]][flight[1]] = flight[2];
//        }
//
//        int[] minCost = new int[n];
//        int[] stops = new int[n];
//        Arrays.fill(minCost, Integer.MAX_VALUE);
//        Arrays.fill(stops, Integer.MAX_VALUE);
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        minCost[src] = 0;
//        stops[src] = 0;
//        minHeap.offer(new int[]{src, 0, 0});
//
//        // Dijkstra
//        while (!minHeap.isEmpty()) {
//            int[] entry = minHeap.poll();
//
//            // check dst
//            if (entry[0] == dst) {
//                return entry[1];
//            }
//
//            // check stops
//            if (entry[2] == k + 1) {
//                continue;
//            }
//
//            // expand
//            for (int i = 0; i < n; i++) {
//                if (matrix[entry[0]][i] > 0) {
//                    int cost = matrix[entry[0]][i];
//
//                    // check
//                    if (entry[1] + cost < minCost[i]) {
//                        minCost[i] = entry[1] + cost;
//                        stops[i] = entry[2];
//                        minHeap.offer(new int[]{i, entry[1] + cost, entry[2] + 1});
//                    } else if (entry[2] < stops[i]) {
//                        minHeap.offer(new int[]{i, entry[1] + cost, entry[2] + 1});
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    // approach 2 - Dijkstra Algorithm TC: O(O(V^2logV)) SC: O(V^2)
    // TC of Dijkstra = O(V) * Insert operations + O(V) * PollMin() + O(E) * DecreaseKeys() -> O(V) + O(ElogV)
    // Worst case: E = V^2
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        // adjacent matrix
        int[][] matrix = new int[n][n];
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        // [src, costs, stops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] minCosts = new int[n];
        int[] minStops = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minCosts[src] = 0;
        minStops[src] = 0;
        minHeap.offer(new int[]{src, 0, 0});

        // Dijkstra
        while (!minHeap.isEmpty()) {
            int[] entry = minHeap.poll();

            // check within k stops
            if (entry[2] > k + 1) {
                continue;
            }

            // check dst
            if (entry[0] == dst) {
                return entry[1];
            }

            // expand
            for (int i = 0; i < n; i++) {
                // check valid paths
                int cost = matrix[entry[0]][i];
                if (cost > 0) {
                    // update rule 1: cost(src, v) + cost(v, w) < minCost(w)
                    // update rule 2: minStops(v) + 1 < minStops(w)
                    if (entry[1] + cost < minCosts[i]) {
                        minCosts[i] = entry[1] + cost;
                        minStops[i] = entry[2] + 1;
//                        parent[i] = entry[0];
                        minHeap.offer(new int[]{i, minCosts[i], entry[2] + 1});
                    } else if (entry[2] + 1 < minStops[i]) {
                        //  minStops[i] = entry[2] + 1;
//                        parent[i] = entry[0];
                        minHeap.offer(new int[]{i, entry[1] + cost, entry[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    // Follow-up: print path
    public class Node {
        int index;
        int cost;
        int stop;
        List<Integer> path;

        public Node(int index, int cost, int stop) {
            this.index = index;
            this.cost = cost;
            this.stop = stop;
            this.path = new ArrayList<>();
        }
    }
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        // adjacent matrix
        int[][] matrix = new int[n][n];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        // [src, costs, stops]
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] minCosts = new int[n];
        int[] minStops = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minCosts[src] = 0;
        minStops[src] = 0;
        Node root = new Node(src, 0, 0);
        root.path.add(src);
        minHeap.offer(root);

        // Dijkstra
        while (!minHeap.isEmpty()) {
            Node entry = minHeap.poll();

            // check within k stops
            if (entry.stop > k + 1) {
                continue;
            }

            // check dst
            if (entry.index == dst) {
                System.out.println(entry.path);
                return entry.cost;
            }

            // expand
            for (int i = 0; i < n; i++) {
                // check valid paths
                int cost = matrix[entry.index][i];
                if (cost > 0) {
                    // update rule 1: cost(src, v) + cost(v, w) < minCost(w)
                    // update rule 2: minStops(v) + 1 < minStops(w)
                    if (entry.cost + cost < minCosts[i]) {
                        minCosts[i] = entry.cost + cost;
                        minStops[i] = entry.stop + 1;
                        Node node = new Node(i, minCosts[i], entry.stop + 1);
                        node.path.addAll(entry.path);
                        node.path.add(i);
                        minHeap.offer(node);
                    } else if (entry.stop + 1 < minStops[i]) {
                        Node node = new Node(i, entry.cost + cost, entry.stop + 1);
                        node.path.addAll(entry.path);
                        node.path.add(i);
                        minHeap.offer(node);
                    }
                }
            }
        }
        System.out.println(new ArrayList<>());
        return -1;
    }

    // approach 1 - Dijkstra TC: O(N + EKlogEK) SC: O(N + EK)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new ArrayList<>());
            }
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // {dist_from_src_node, node, number_of_stops_from_src_node}
        pq.offer(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];
            int dist = temp[1];
            int steps = temp[2];

            // We have already encountered a path with a lower cost and fewer stops,
            // or the number of stops exceeds the limit.
            if (steps > stops[node] || steps > k + 1) {
                continue;
            }
            stops[node] = steps;


            if (node == dst) {
                return dist;
            }
            if (!map.containsKey(node))
                continue;
            for (int[] a : map.get(node)) {
                pq.offer(new int[] {a[0], dist + a[1], steps + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops test = new CheapestFlightsWithinKStops();
//        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
//        int[][] flights = new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int[][] flights = new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        System.out.println(test.findCheapestPrice(4, flights, 0, 3, 1));
    }
}
