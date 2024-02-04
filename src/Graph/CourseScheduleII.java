package Graph;

/*
LeetCode 210

There are a total of n courses you have to take, labeled from 0 to n - 1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

        For example:

        2, [[1,0]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

        4, [[1,0],[2,0],[3,1],[3,2]]
        There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/

import java.util.*;

public class CourseScheduleII {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // initialize the graph
//        Map<Integer, List<Integer>> indegreeMap = new HashMap<>();
//        for (int[] preq : prerequisites) {
//            if (!indegreeMap.containsKey(preq[1])) {
//                indegreeMap.put(preq[1], new ArrayList<>());
//            }
//            indegreeMap.get(preq[1]).add(preq[0]);
//        }
//
//        // initialize indegrees of each vertex
//        int[] res = new int[numCourses];
//        int[] indegreeArr = new int[numCourses];
//        for (Integer key : indegreeMap.keySet()) {
//            for (Integer val : indegreeMap.get(key)) {
//                indegreeArr[val]++;
//            }
//        }
//
//        // initialize queue with 0-indegree vertices
//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegreeArr[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        // topological sort
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            res[count++] = course;
//            if (indegreeMap.containsKey(course)) {
//                for (Integer n : indegreeMap.get(course)) {
//                    indegreeArr[n]--;
//                    if (indegreeArr[n] == 0) {
//                        queue.add(n);
//                    }
//                }
//            }
//        }
//        return count == numCourses ? res : new int[0];
//    }

    // approach 1: Graph + BFS TC: O(V + E) SC: O(V + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // initialization
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] preq : prerequisites) {
            // init
            if (!map.containsKey(preq[1])) {
                map.put(preq[1], new ArrayList<>());
            }
            map.get(preq[1]).add(preq[0]);
            indegrees[preq[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            // check origin/start
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[count++] = course;

            // expand
            if (map.containsKey(course)) {
                for (int nextCourse : map.get(course)) {
                    // update
                    indegrees[nextCourse]--;

                    // check
                    if (indegrees[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII test = new CourseScheduleII();
        int[][] arr = new int[][]{};
        System.out.println(Arrays.toString(test.findOrder(0, arr)));
    }
}
