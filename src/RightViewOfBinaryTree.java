import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightViewOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        // edge case
        if (root != null) {
            queue.offer(root);
        }

        // BFS - Level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // keep the rightmost node
                if (i == size - 1) {
                    res.add(node.val);
                }

                // check children
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
