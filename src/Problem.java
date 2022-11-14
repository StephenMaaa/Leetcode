public class Problem {
    public int getKthSum(int[] arr1, int[] arr2, int k) {
        if (k >= arr1.length + arr2.length) {
            return arr1[arr1.length - 1] + arr2[arr2.length - 1];
        }

        int p1 = 0, p2 = 0, count = 1;
        while (count < k) {
//            // p1 is full
//            if (p1 == arr1.length - 1) {
//
//            }

            if (arr1[p1] < arr2[p2]) {
                if (p1 == arr1.length - 1) {
                    p2++;
                } else {
                    p1++;
                }
            } else {
                if (p2 == arr2.length - 1) {
                    p1++;
                } else {
                    p2++;
                }
            }
            count++;
        }
        return arr1[p1] + arr2[p2];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7};
        int[] b = new int[]{4, 5, 6};
        Problem test = new Problem();
        System.out.println(test.getKthSum(a, b, 5));
    }
}
