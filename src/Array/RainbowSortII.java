package Array;

/*
Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, sort the balls such that all balls with same color are grouped together and from left to right the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3).

        Examples

        {0} is sorted to {0}
        {1, 0} is sorted to {0, 1}
        {1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}
        Assumptions

        The input array is not null.
*/

import java.util.Arrays;

public class RainbowSortII {
    // count sort - TC: O(n) SC: O(1)
    // rainbow sort - TC: O(n) SC: O(1)
    public int[] rainbowSortII(int[] array) {
        int red = 0;
        int green = 0;
        int blue = 0;
        int black = array.length - 1;
        while (blue <= black) {
            // case 1: red
            // case 2: green
            // case 3: blue
            // case 4: black
            if (array[blue] == 0) {
                swap(array, blue, red);
                // special case
                if (red < green) {
                    swap(array, blue, green);
                }
                red++;
                green++;
                blue++;
            } else if (array[blue] == 1) {
                swap(array, blue, green);
                green++;
                blue++;
            } else if (array[blue] == 2) {
                blue++;
            } else {
                swap(array, blue, black);
                black--;
            }
        }
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RainbowSortII test = new RainbowSortII();
        int[] arr = new int[]{2, 0, 3, 0, 1, 0};
        System.out.println(Arrays.toString(test.rainbowSortII(arr)));
    }
}
