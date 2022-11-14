package LinkedList;

/*
Make a deep copy of an undirected graph, there could be cycles in the original graph.

        Assumptions

        The given graph is not null
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepcopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        // edge case
        if (graph.isEmpty()) {
            return new ArrayList<>();
        }

        List<GraphNode> ans = new ArrayList<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
            }
            GraphNode newNode = map.get(node);
            for (GraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new GraphNode(neighbor.key));
                }
                newNode.neighbors.add(map.get(neighbor));
            }
            ans.add(newNode);
        }
        return ans;
    }
}
