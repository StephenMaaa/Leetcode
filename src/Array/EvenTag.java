package Array;

public class EvenTag {
    public int evenTag(int[] arr) {
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }

            if (arr[i] % 2 != 0) {
                minOdd = Math.min(minOdd, Math.abs(arr[i]));
            }
        }

        // check
        if (sum % 2 == 0) {
            return sum;
        } else {
            return sum - minOdd;
        }
    }

    public static void main(String[] args) {
        EvenTag test = new EvenTag();
        int[] arr = new int[]{2, 3, 6, -5, 10, 1, 1};
        System.out.println(test.evenTag(arr)); 
    }
}
