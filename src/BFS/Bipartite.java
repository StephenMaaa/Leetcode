package BFS;

/*
Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.

        Examples

        1  --   2

        /

        3  --   4

        is bipartite (1, 3 in group 1 and 2, 4 in group 2).

        1  --   2

        /   |

        3  --   4

        is not bipartite.

        Assumptions

        The graph is represented by a list of nodes, and the list of nodes is not null.
*/

import LinkedList.GraphNode;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // edge case
        if (graph == null || graph.size() == 0) {
            return true;
        }

        // visited map
        Map<GraphNode, Boolean> map = new HashMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (map.containsKey(graph.get(i))) {
                continue;
            }

            // initialize
            Queue<GraphNode> queue = new ArrayDeque<>();
            queue.offer(graph.get(i));
            map.put(graph.get(i), true);

            while (!queue.isEmpty()) {
                GraphNode node = queue.poll();
                boolean flag = map.get(node);

                for (GraphNode neighbor : node.neighbors) {
                    if (map.containsKey(neighbor)) {
                        if (map.get(neighbor) == flag) {
                            return false;
                        }
                    } else {
                        map.put(neighbor, !flag);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean f = false;
        boolean t = !f;
        System.out.println(t);
    }
}
