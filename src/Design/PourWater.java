package Design;

/*
You are given an elevation map represents as an integer array heights where heights[i] representing the height of the terrain at index i. The width at each index is 1. You are also given two integers volume and k. volume units of water will fall at index k.

        Water first drops at the index k and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:

        If the droplet would eventually fall by moving left, then move left.
        Otherwise, if the droplet would eventually fall by moving right, then move right.
        Otherwise, rise to its current position.
        Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. Also, level means the height of the terrain plus any water in that column.

        We can assume there is infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly on more than one grid block, and each unit of water has to be in exactly one block.
*/

import java.util.Arrays;

public class PourWater {
    // idea: find local minimum that is closest to index k
    // while loop
    // move to leftmost
    // move back to rightmost (rightmost in the left / rightmost in the right)
    // move back to leftmost in the right (if rightmost in the right)

    // approach 1 - Linear Scan TC: O(VN) SC: O(1)
    public int[] pourWater(int[] heights, int volume, int k) {
        int[] walls = heights.clone();
        int pointer = k;
        while (volume > 0) {
            // int pointer = k;
            // move to the leftmost
            while (pointer > 0 && heights[pointer] >= heights[pointer - 1]) {
                pointer--;
            }

            // move to the rightmost
            while (pointer < heights.length - 1 && heights[pointer] >= heights[pointer + 1]) {
                pointer++;
            }

            // case 1: rightmost in the left -> skip
            // case 2: rightmost in the right -> leftmost in the right
            while (pointer > k && heights[pointer - 1] <= heights[pointer]) {
                pointer--;
            }

            // update
            heights[pointer]++;
            volume--;
        }

        print(heights, walls);
        return heights; 
    }

    // Follow-up
    private void print(int[] heights, int[] walls) {
        // print from top to bottom
        int maxHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
        }

        for (int height = maxHeight; height > 0; height--) {
            // case 1: walls < height <= heights -> water
            // case 2: 0 < i <= walls -> walls
            // case 3: heights < i -> blank
            for (int i = 0; i < heights.length; i++) {
                if (walls[i] < height && height <= heights[i]) {
                    System.out.print(".");
                } else if (height <= walls[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        PourWater test = new PourWater();
        int[] heights = new int[]{2, 1, 1, 2, 1, 2, 2};
        System.out.println(Arrays.toString(test.pourWater(heights, 4, 3)));
    }
}
