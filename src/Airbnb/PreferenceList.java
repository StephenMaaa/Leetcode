package Airbnb;

import java.util.*;

public class PreferenceList {
    // approach 1 - Topological Sort (BFS) TC: O(V + E) SC: O(V + E)
    public List<Integer> preferenceList(List<List<Integer>> preferences) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (List<Integer> list : preferences) {
            for (int i = 0; i < list.size() - 1; i++) {
                int src = list.get(i);
                int dst = list.get(i + 1);

                // initialization
                if (!map.containsKey(src)) {
                    map.put(src, new HashSet<>());
                    inDegrees.put(src, 0);
                }

                if (!map.containsKey(dst)) {
                    map.put(dst, new HashSet<>());
                    inDegrees.put(dst, 0);
                }

                // add edge src -> dst
                map.get(src).add(dst);
                inDegrees.put(dst, inDegrees.get(dst) + 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        // initialization
        Deque<Integer> queue = new ArrayDeque<>();
        for (int key : inDegrees.keySet()) {
            if (inDegrees.get(key) == 0) {
                queue.offer(key);
            }
        }

        // topological sort
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            // expand
            if (map.containsKey(node)) {
                for (int next : map.get(node)) {
                    // update the indegree for next node
                    int count = inDegrees.get(next);
                    inDegrees.put(next, count - 1);

                    // check
                    if (count == 1) {
                        queue.offer(next);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PreferenceList test = new PreferenceList();

        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 5, 7, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5,8));
        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);

        List<Integer> result = test.preferenceList(input);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + ",");
        }
    }
}
