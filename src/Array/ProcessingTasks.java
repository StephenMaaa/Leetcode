package Array;

import java.util.*;

public class ProcessingTasks {
    public int processingTasks(List<List<Integer>> tasks) {
        // greedy: sort by end time
        Collections.sort(tasks, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < tasks.size(); i++) {
            List<Integer> task = tasks.get(i);
            int start = task.get(0);
            int end = task.get(1);
            int period = task.get(2);
            int count = 0;
            for (int j = start; j <= end; j++) {
                if (visited.contains(j)) {
                    count++;
                }
            }

            // check
            if (count >= period) {
                continue;
            }

            for (int j = end; j >= start; j--) {
                if (!visited.contains(j)) {
                    visited.add(j);
                    count++;
                }

                if (count == period) {
                    break;
                }
            }
        }
        return visited.size();
    }

    public static void main(String[] args) {
        ProcessingTasks test = new ProcessingTasks();
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 3, 2));
        arr.add(Arrays.asList(2, 5, 3));
        arr.add(Arrays.asList(5, 6, 2));
        System.out.println(test.processingTasks(arr));
    }
}
