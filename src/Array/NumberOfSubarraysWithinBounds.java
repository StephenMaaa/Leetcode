package Array;

public class NumberOfSubarraysWithinBounds {
    // approach 1 - Sliding Window TC: O(n) SC: O(1)
    public int numberOfSubarraysWithinBounds(int[] arr, int lower, int upper) {
        // sliding window
        // case 1: arr[i] in bounds -> ++
        // case 2: out of bound -> accumulate previous result

        int res = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= lower && arr[i] <= upper) {
                continue;
            }

            while (start < i) {
                res += i - start - 1;
                start++;
            }
            start++;
        }

        // append rest
        while (start < arr.length) {
            res += arr.length - start - 1;
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithinBounds test = new NumberOfSubarraysWithinBounds();
        int[] arr = new int[]{1, 2, 3, 2, 4};
        System.out.println(test.numberOfSubarraysWithinBounds(arr, 2, 3));
    }
}
