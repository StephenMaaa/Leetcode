package Graph;

import java.util.*;

/*
Given a reference of a node in a connected undirected graph.

        Return a deep copy (clone) of the graph.

        Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


Test case format:

        For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

        An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

        The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
*/

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    // approach 1: Map TC: O(V + E) SC: O(V + E)
    public Node cloneGraph(Node node) {
        // edge case
        if (node == null) {
            return null;
        }

        // initialization
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        // BFS
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node currCopy = map.get(curr);
            List<Node> neighbors = curr.neighbors;

            // explore
            for (Node neighbor : neighbors) {
                // check
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                // update copied neighbors
                currCopy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        CloneGraph test = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node copy = test.cloneGraph(node1);
    }
}
