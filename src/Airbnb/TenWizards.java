package Airbnb;

import java.util.*;

public class TenWizards {
    // approach 1 - Dijkstra TC: O(ElogV) SC: O(V + E)
    // TC of Dijkstra = O(V) * Insert operations + O(V) * PollMin() + O(E) * DecreaseKeys() -> O(V) + O(ElogV)
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int src, int target) {
        int[] minDistances = new int[wizards.size()];
        int[] parent = new int[wizards.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] entry = pq.poll();

            List<Integer> neighbors = wizards.get(entry[0]);
            for (int next : neighbors) {
                int dis = (int) Math.pow(entry[0] - next, 2);

                // check
                if (entry[1] + dis < minDistances[next]) {
                    minDistances[next] = entry[1] + dis;
                    parent[next] = entry[0];
                    pq.offer(new int[]{next, entry[1] + dis});
                }
            }
        }

        // get path
        List<Integer> res = new ArrayList<>();
        int t = target;
        while (t != src) {
            res.add(t);
            t = parent[t];
        }
        res.add(src);
        Collections.reverse(res);
        return res;
    }

//    class Wizard implements Comparable<Wizard> {
//        int id;
//        int dist;
//        // Map<Integer, Integer> costs;
//
//        Wizard(int id) {
//            this.id = id;
//            this.dist = Integer.MAX_VALUE;
//            // this.costs = new HashMap<>();
//        }
//
//        @Override
//        public int compareTo(Wizard that) {
//            return this.dist - that.dist;
//        }
//    }
//
//    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
//        if (wizards == null || wizards.size() == 0) return null;
//        int n = wizards.size();
//        int[] parent = new int[n];
//        Map<Integer, Wizard> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            map.put(i, new Wizard(i));
//        }
//
//        map.get(source).dist = 0;
//        Queue<Wizard> pq = new PriorityQueue<>(n);
//        pq.offer(map.get(source));
//        while (!pq.isEmpty()) {
//            Wizard curr = pq.poll();
//            List<Integer> neighbors = wizards.get(curr.id);
//            for (int neighbor : neighbors) {
//                Wizard next = map.get(neighbor);
//                int weight = (int) Math.pow(next.id - curr.id, 2);
//                if (curr.dist + weight < next.dist) {
//                    parent[next.id] = curr.id;
//                    pq.remove(next);
//                    next.dist = curr.dist + weight;
//                    pq.offer(next);
//                }
//            }
//        }
//
//        List<Integer> res = new ArrayList<>();
//        int t = target;
//        while (t != source) {
//            res.add(t);
//            t = parent[t];
//        }
//        res.add(source);
//        Collections.reverse(res);
//        return res;
//    }

    public static void main(String[] args) {
        TenWizards test = new TenWizards();

        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                list.add(2);
            } else if (i == 1) {
                list.add(3);
            } else if (i == 2) {
                list.add(3);
                list.add(4);
            } else if (i == 3) {
                list.add(4);
            }
            wizards.add(list);
        }
        List<Integer> path = test.getShortestPath(wizards, 0, 4);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
    }
}
