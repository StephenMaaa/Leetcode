public class MinimumTimeForFishing {
    public int minimumTimeForFishing(int[] arr, int k) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int min = sum;

        // binary search
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = (left + right) >> 1;

            // check
            int count = 0;
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                    count++;
                }
            }

            if (count < k) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTimeForFishing test = new MinimumTimeForFishing();
        int[] arr = new int[]{7, 2, 5, 10, 8};
        System.out.println(test.minimumTimeForFishing(arr, 2));
    }
}
