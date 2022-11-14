package Array;

/*
Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

        Assumptions

        The given array is not null
        Examples

        A = {1, 2, 1, 2, 1}, return [1, 2]
        A = {1, 2, 1, 2, 3, 3, 1}, return [1]
        A = {1, 2, 2, 3, 1, 3}, return []
*/

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberII {
    // approach 1 - Boyer Moore Majority-voting Algorithm TC: O(n) SC: O(1)
    public List<Integer> majorityElement(int[] nums) {
        int candidateA = 0;
        int candidateB = 0;
        int countA = 0;
        int countB = 0;
        // first pass
        for (int i = 0; i < nums.length; i++) {
            // case 1: candidateA
            // case 2: candidateB
            // case 3: countA == 0
            // case 4: countB == 0
            // case 5: neither
            if (countA > 0 && candidateA == nums[i]) {
                countA++;
            } else if (countB > 0 && candidateB == nums[i]) {
                countB++;
            } else if (countA == 0) {
                candidateA = nums[i];
                countA++;
            } else if (countB == 0) {
                candidateB = nums[i];
                countB++;
            }else {
                countA--;
                countB--;
            }
        }

        // second pass
        countA = 0;
        countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidateA == nums[i]) {
                countA++;
            } else if (candidateB == nums[i]) {
                countB++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (countA > nums.length / 3) {
            res.add(candidateA);
        }

        if (countB > nums.length / 3) {
            res.add(candidateB);
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityNumberII test = new MajorityNumberII();
        int[] arr = new int[]{0, 3, 4, 0};
        System.out.println(test.majorityElement(arr));
    }
}
