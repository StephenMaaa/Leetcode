package Array;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
     // approach 1 - Map TC: O(MAX(m, n)) SC: O(MIN(m, n))
     public int[] intersect(int[] A, int[] B) {
         int[] arrS;
         int[] arrL;
         if (A.length < B.length) {
             arrS = A;
             arrL = B;
         } else {
             arrS = B;
             arrL = A;
         }
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < arrS.length; i++) {
             map.put(arrS[i], map.getOrDefault(arrS[i], 0) + 1);
         }
         List<Integer> ans = new ArrayList<>();
         for (int i = 0; i < arrL.length; i++) {
             Integer val = map.get(arrL[i]);
             if (val != null && val > 0) {
                 map.put(arrL[i], val - 1);
                 ans.add(arrL[i]);
             }
         }

             int[] arr = new int[ans.size()];
         for (int i = 0; i < ans.size(); i++) {
             arr[i] = ans.get(i);
         }
         return arr;
     }

    // approach 2 - Two Pointers TC: O(MAX(mlogm, nlogn)) SC: O(MIN(m, n))
    public int[] intersection(int[] nums1, int[] nums2) {
        // sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < nums1.length && pointerB < nums2.length) {
            // dedup
            while (pointerA < nums1.length - 1 && nums1[pointerA] == nums1[pointerA + 1]) {
                pointerA++;
            }

            while (pointerB < nums2.length - 1 && nums2[pointerB] == nums2[pointerB + 1]) {
                pointerB++;
            }

            // case 1: ==
            // case 2: <
            // case 3: >
            if (nums1[pointerA] == nums2[pointerB]) {
                list.add(nums1[pointerA]);
                pointerA++;
                pointerB++;
            } else if (nums1[pointerA] < nums2[pointerB]) {
                pointerA++;
            } else {
                pointerB++;
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{};
        System.out.println(Arrays.toString(test.intersection(arr1, arr2)));
    }
}
