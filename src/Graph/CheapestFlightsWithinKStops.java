package Graph;

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

    // approach 2 - Dijikstra Algorithm TC: O(V^2logV) SC: O(V^2)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // build adjacency matrix
        int[][] matrix = new int[n][n];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }

        int[] minCost = new int[n];
        int[] stops = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minCost[src] = 0;
        stops[src] = 0;
        minHeap.offer(new int[]{src, 0, 0});

        // Dijkstra
        while (!minHeap.isEmpty()) {
            int[] entry = minHeap.poll();

            // check dst
            if (entry[0] == dst) {
                return entry[1];
            }

            // check stops
            if (entry[2] == k + 1) {
                continue;
            }

            // expand
            for (int i = 0; i < n; i++) {
                if (matrix[entry[0]][i] > 0) {
                    int cost = matrix[entry[0]][i];

                    // check
                    if (entry[1] + cost < minCost[i]) {
                        minCost[i] = entry[1] + cost;
                        stops[i] = entry[2];
                        minHeap.offer(new int[]{i, entry[1] + cost, entry[2] + 1});
                    } else if (entry[2] < stops[i]) {
                        minHeap.offer(new int[]{i, entry[1] + cost, entry[2] + 1});
                    }
                }
            }
        }
        return -1; 
    }
}
