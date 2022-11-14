package Array;

/*
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

        Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

        Return the minimum time Bob needs to make the rope colorful.
*/

public class MinimumTimeToMakeRopeColorful {
    // approach 1 - Arrays TC: O(n) SC: O(1)
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int i = 0;
        while (i < colors.length()) {
            // read all colors in a row
            int max = 0;
            while (i < colors.length() - 1 && colors.charAt(i) == colors.charAt(i + 1)) {
                res += neededTime[i];
                max = Math.max(max, neededTime[i]);
                i++;
            }
            max = Math.max(max, neededTime[i]);
            res += neededTime[i];

            // remove the largest cost
            res -= max;
            i++;
        }
        return res; 
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful test = new MinimumTimeToMakeRopeColorful();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(test.minCost("abaac", arr));
    }
}
