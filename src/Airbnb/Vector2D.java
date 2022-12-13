package Airbnb;
import java.util.NoSuchElementException;

/*
Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.

        Implement the Vector2D class:

        Vector2D(int[][] vec) initializes the object with the 2D vector vec.
        next() returns the next element from the 2D vector and moves the pointer one step forward. You may assume that all the calls to next are valid.
        hasNext() returns true if there are still some elements in the vector, and false otherwise.
*/

// // approach 1 - List
// class Vector2D {
//     List<Integer> list;
//     int index;

//     // TC: O(N + V) SC: O(N)
//     public Vector2D(int[][] vec) {
//         this.list = new ArrayList<>();
//         for (int[] arr : vec) {
//             for (int i : arr) {
//                 list.add(i);
//             }
//         }
//         this.index = 0;
//     }

//     // TC: O(1) SC: O(1)
//     public int next() {
//         // check
//         if (!hasNext()) {
//             throw new NoSuchElementException();
//         }
//         return list.get(index++);
//     }

    //     // TC: O(1) SC: O(1)
//     public boolean hasNext() {
//         return index < list.size();
//     }
// }

public class Vector2D {
    int[][] list;
    int indexL1;
    int indexL2;

    // TC: O(1) SC: O(1)
    public Vector2D(int[][] vec) {
        this.list = vec;
        this.indexL1 = 0;
        this.indexL2 = 0;
    }

    // TC: O((N + V) / N) SC: O(1)
    private void iter() {
        while (indexL1 < list.length && indexL2 == list[indexL1].length) {
            indexL1++;
            indexL2 = 0;
        }
    }

    // TC: O((N + V) / N) SC: O(1)
    public int next() {
        // iter
        iter();

        // check
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int val = list[indexL1][indexL2++];
        // iter
        iter();
        return val;
    }

    // TC: O(1) SC: O(1)
    public boolean hasNext() {
        return indexL1 != list.length;
    }

    public static void main(String[] args) {
        int[][] vec = new int[][]{{1, 2}, {3}, {4}, {}, {}, {}, {}};
        Vector2D test = new Vector2D(vec);
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.hasNext());
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.hasNext());
    }
}




