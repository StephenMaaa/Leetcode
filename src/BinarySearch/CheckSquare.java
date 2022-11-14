package BinarySearch;

/*
Given the coordinates of four points in 2D space, return whether the four points form a square.

        The coordinate (x,y) of a point is represented by an integer array with two integers.

        Example:

        Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
        Output: True
        Note:

        All the input integers are in the range [-10000, 10000].
        A valid square has four equal sides with positive length and four equal angles (90-degree angles).
        Input points have no order.
*/

public class CheckSquare {
    public boolean checkSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // avoid same points
        if (isSame(p1, p2) || isSame(p1, p3) || isSame(p1, p4) || isSame(p2, p3) || isSame(p3, p4)) {
            return false;
        }

        // square: P(4, 4)
        // symmetry: 4 rotations * 2 flips
        boolean type1 = dis(p1, p2) == dis(p1, p4) && dis(p2, p3) == dis(p3, p4);
        boolean type2 = dis(p1, p3) == dis(p1, p4) && dis(p2, p3) == dis(p2, p4);
        boolean type3 = dis(p1, p2) == dis(p1, p3) && dis(p2, p4) == dis(p3, p4);
        return dis(p1, p4) == dis(p2, p3) && dis(p1, p2) == dis(p3, p4) && dis(p1, p3) == dis(p2, p4) && (type1 ^ type2 ^ type3);
    }

    private boolean isSame(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private double dis(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    public static void main(String[] args) {
        CheckSquare test = new CheckSquare();
        int[] p1 = new int[]{0, -1};
        int[] p2 = new int[]{-1, 0};
        int[] p3 = new int[]{-1, 0};
        int[] p4 = new int[]{0, -1};
        System.out.println(test.checkSquare(p1, p2, p3, p4));
    }
}
