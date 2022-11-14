package Tree;

/*
Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
*/

public class LCAVII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    // approach 1 - Iteration TC: O(h) SC: O(1)
    public Node lowestCommonAncestor(Node p, Node q) {
        // get p's depth
        Node temp = p;
        int pDepth = 0;
        while (temp != null) {
            temp = temp.parent;
            pDepth++;
        }

        // get q's depth 
        temp = q;
        int qDepth = 0;
        while (temp != null) {
            temp = temp.parent;
            qDepth++;
        }

        // move the deeper node up by the diff depth
        int count = Math.abs(pDepth - qDepth);
        if (pDepth < qDepth) {
            while (count > 0) {
                q = q.parent;
                count--;
            }
        } else {
            while (count > 0) {
                p = p.parent;
                count--;
            }
        }

        // find LCA
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
}
