package Array;

/*
Determine if the given integer array is min heap.
*/

public class DetermineIfArrayIsMinHeap {
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean isMinHeap(int[] array) {
        // edge case
        if (array == null || array.length == 0) {
            return true;
        }

        for (int i = 0; i < array.length / 2 + 1; i++) {
            // arr[i] left child -> arr[2i + 1]
            // arr[i] right child -> arr[2i + 2]

            if (2 * i + 1 < array.length && array[i] > array[2 * i + 1]) {
                return false;
            }

            if (2 * i + 2 < array.length && array[i] > array[2 * i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineIfArrayIsMinHeap test = new DetermineIfArrayIsMinHeap();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(test.isMinHeap(arr));
    }
}
