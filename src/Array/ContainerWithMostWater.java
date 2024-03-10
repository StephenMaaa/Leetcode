package Array;

/*
LeetCode 11

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.

        Notice that you may not slant the container.
*/

public class ContainerWithMostWater {
//    // approach 1: Two Pointers TC: O(n) SC: O(1)
//    public int maxArea(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int max = 0;
//
//        while (left < right) {
//            // calculate volume
//            int volume = Math.min(height[left], height[right]) * (right - left);
//
//            // update max
//            max = Math.max(max, volume);
//
//            // update left/right pointer
//            if (height[left] < height[right]) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return max;
//    }

    // approach 1: Two Pointers TC: O(n) SC: O(1)
    public int maxArea(int[] height) {
        // initialization
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        // two pointers scan
        while (left < right) {
            // calculate volume
            int volume = Math.min(height[left], height[right]) * (right - left);

            // update
            max = Math.max(volume, max);

            // move
            // case 1: left < right
            // case 2: otherwise
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(test.maxArea(arr));
    }
}
