package HashTable;

import java.util.HashMap;
import java.util.Map;

public class EfficientTeams {
    public int efficientTeams(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // check
        if (sum % (arr.length / 2) != 0) {
            return -1;
        }

        int target = sum / (arr.length / 2);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // check
            if (arr[i] > target) {
                return -1;
            }

            // check existence
            if (map.containsKey(target - arr[i])) {
                int count = map.get(target - arr[i]);
                if (count == 1) {
                    map.remove(target - arr[i]);
                } else {
                    map.put(target - arr[i], count - 1);
                }
                res += arr[i] * (target - arr[i]);
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EfficientTeams test = new EfficientTeams();
        int[] arr = new int[]{1, 2, 3, 2};
        System.out.println(test.efficientTeams(arr));
    }
}
