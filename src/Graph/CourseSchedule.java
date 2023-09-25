package Graph;

/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

        For example:

        2, [[1,0]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

        2, [[1,0],[0,1]]
        There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

        Note:

        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
        You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.*;

public class CourseSchedule {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] indegreeArr = new int[numCourses];
//        Map<Integer, List<Integer>> indegreeMap = new HashMap<>();
//        for (int[] pair : prerequisites) {
//            if (!indegreeMap.containsKey(pair[1])) {
//                indegreeMap.put(pair[1], new ArrayList<>());
//            }
//            indegreeMap.get(pair[1]).add(pair[0]);
//            indegreeArr[pair[0]]++;
//        }
//
//        // BFS
//        // initialization
//        Deque<Integer> queue = new ArrayDeque<>();
//        int count = 0;
//        for (int i = 0; i < indegreeArr.length; i++) {
//            if (indegreeArr[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            count++;
//
//            // expand
//            if (indegreeMap.containsKey(course)) {
//                for (int nextCourse : indegreeMap.get(course)) {
//                    if (--indegreeArr[nextCourse] == 0) {
//                        queue.offer(nextCourse);
//                    }
//                }
//            }
//        }
//        return count == numCourses;
//    }

//    // idea: Topological Sort
//    // Initialization: indegree map, queue filling with nodes with 0 indegree
//    // BFS
//    // final check
//
//    // approach 1 - Topological Sort TC: O(V + E) SC: O(V + E)
//    public boolean canFinish2(int numCourses, int[][] prerequisites) {
//        // initialization
//        Map<Integer, List<Integer>> indegreeMap = new HashMap<>();
//        int[] indegrees = new int[numCourses];
//        int count = 0;
//        for (int[] pair : prerequisites) {
//            if (!indegreeMap.containsKey(pair[1])) {
//                indegreeMap.put(pair[1], new ArrayList<>());
//            }
//            indegreeMap.get(pair[1]).add(pair[0]);
//            indegrees[pair[0]]++;
//        }
//
//        Deque<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegrees[i] == 0) {
//                queue.offer(i);
//                count++;
//            }
//        }
//
//        // BFS
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//
//            // expand
//            if (indegreeMap.containsKey(course)) {
//                for (int nextCourse : indegreeMap.get(course)) {
//                    indegrees[nextCourse]--;
//
//                    // check
//                    if (indegrees[nextCourse] == 0) {
//                        queue.offer(nextCourse);
//                        count++;
//                    }
//                }
//            }
//        }
//        return count == numCourses;
//    }

    // approach 1: Topological Sort TC: O(V + E) SC: O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> indegreeMap = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] course : prerequisites) {
            // initialize
            if (!indegreeMap.containsKey(course[1])) {
                indegreeMap.put(course[1], new ArrayList<>());
            }
            indegreeMap.get(course[1]).add(course[0]);
            indegrees[course[0]]++;
        }

        // topological sort
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;

        // initialize queue
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        // expand
        while (!queue.isEmpty()) {
            int course = queue.poll();

            if (indegreeMap.containsKey(course)) {
                // explore
                for (int nextCourse : indegreeMap.get(course)) {
                    indegrees[nextCourse]--;

                    // add
                    if (indegrees[nextCourse] == 0) {
                        queue.offer(nextCourse);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule test = new CourseSchedule();
        int[][] preq = new int[][]{{0, 1}};
        System.out.println(test.canFinish(2, preq));
    }
}
