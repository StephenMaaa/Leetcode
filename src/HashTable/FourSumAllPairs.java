package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// extends from FourSum
public class FourSumAllPairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // sort
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < array.length - 3; i++) {
            // case: duplicate
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int threeSum = target - array[i];
            // three sum
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = array.length - 1;
                int twoSum = threeSum - array[j];
                // two sum
                while (left < right) {
                    if (left > j + 1 && array[left] == array[left - 1]) {
                        left++;
                        continue;
                    }

                    if (array[left] + array[right] == twoSum) {
                        ans.add(Arrays.asList(array[i], array[j], array[left], array[right]));
                        left++;
                        right--;
                    } else if (array[left] + array[right] < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSumAllPairs test = new FourSumAllPairs();
        int[] arr = new int[]{1, 2, 4, 0, 0, 2, 2, 2, 3, 4};
        System.out.println(test.allPairs(arr, 8));
    }
}
