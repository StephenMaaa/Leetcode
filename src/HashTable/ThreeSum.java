package HashTable;

/*
LeetCode 15

Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

        Assumptions

        The given array is not null and has length of at least 3
        No duplicate triples should be returned, order of the values in the tuple does not matter
        Examples

        A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
*/

import java.util.*;

public class ThreeSum {
//    public List<List<Integer>> allTriples(int[] array, int target) {
//        // sort
//        Arrays.sort(array);
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i < array.length - 2; i++) {
//            // case: duplicate
//            if (i > 0 && array[i] == array[i - 1]) {
//                continue;
//            }
//
//            int left = i + 1, right = array.length - 1;
//            int remain = target - array[i];
//            while (left < right) {
//                // case: duplicate
//                if (left > i + 1 && array[left] == array[left - 1]) {
//                    left++;
//                    continue;
//                }
//
//                if (array[left] + array[right] == remain) {
//                    ans.add(Arrays.asList(array[i], array[left], array[right]));
//                    left++;
//                    right--;
//                } else if (array[left] + array[right] < remain) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return ans;
//    }
//
//    // approach 1 - Two Pointers + 2 Sum TC: O(n^2) SC: O(logn)
//    public List<List<Integer>> threeSum2(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        // sort
//        Arrays.sort(nums);
//
//        // 3 sum
//        for (int i = 0; i < nums.length - 2; i++) {
//            // dedup
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int remain = 0 - nums[i];
//
//            // 2 sum
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                // dedup
//                if (left > i + 1 && nums[left] == nums[left - 1]) {
//                    left++;
//                    continue;
//                }
//
//                int sum = nums[left] + nums[right];
//
//                if (sum == remain) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
//                } else if (sum < remain) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return res;
//    }

//    // approach 1: Pointers TC: O(n^2) SC: O(logn)
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//
//        // sort
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            // handle duplicate values
//            if (i > 0 && nums[i - 1] == nums[i]) {
//                continue;
//            }
//
//            int remain = -nums[i];
//
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                // handle duplicate values
//                if (left > i + 1 && nums[left - 1] == nums[left]) {
//                    left++;
//                    continue;
//                }
//
//                int sum = nums[left] + nums[right];
//
//                // check
//                if (sum == remain) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    left++;
//                    right--;
//                } else if (sum < remain) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return res;
//    }

    // approach 1: Two Pointers TC: O(n^2) SC: O(logn)
    public List<List<Integer>> threeSum(int[] nums) {
        // initialization
        List<List<Integer>> res = new ArrayList<>();

        // sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // skip the dup
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int remain = nums[i];

            // two pointers scan
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // skip the dup
                if (left > i + 1 && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }

                int sum = nums[left] + nums[right] + remain;

                // check
                // case 1: sum == 0
                // case 2: sum < 0
                // case 3: sum > 0
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] arr = new int[]{0, 0, 0};
        System.out.println(test.threeSum(arr));
    }
}
