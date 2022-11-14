package Array;

/*
Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line, the distance between any two adjacent boards is 1. Consider selecting two boards such that together with the horizontal line they form a container. Find the volume of the largest such container.

        Assumptions

        The given array is not null and has size of at least 2
        Examples

        { 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.
*/

public class LargestContainer {
    // time complexity: O(n)
    // space complexity: O(1)
    public int largest(int[] array) {
        int pointerA = 0;
        int pointerB = array.length - 1;
        int max = 0;
        while (pointerA < pointerB) {
            int vol = (pointerB - pointerA) * Math.min(array[pointerA], array[pointerB]);
            max = Math.max(max, vol);

            // update the pointer
            if (array[pointerA] < array[pointerB]) {
                pointerA++;
            } else {
                pointerB--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestContainer test = new LargestContainer();
        int[] arr = new int[]{ 2, 1, 3, 1, 2, 1};
        System.out.println(test.largest(arr));
    }
}
