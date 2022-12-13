package Airbnb;

import java.util.*;

public class RoundPrices {
    // approach 1 - Sorting TC: O(nlogn) SC: O(n)
    public int[] roundPrices(double[] arr) {
        List<double[]> floorList = new ArrayList<>();
        double sum = 0;
        int floorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int floor = (int) arr[i];
            sum += arr[i];
            floorSum += floor;
            floorList.add(new double[]{i, arr[i] - floor});
        }

        // decreasing order
        Collections.sort(floorList, (a, b) -> Double.compare(b[1], a[1]));
        int diff = (int) sum - floorSum;
        int[] res = new int[arr.length];
        for (int i = 0; i < floorList.size(); i++) {
            int index = (int) floorList.get(i)[0];
            if (i < diff) {
                res[index] = (int) arr[index] + 1;
            } else {
                res[index] = (int) arr[index];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RoundPrices test = new RoundPrices();

//        double[] input = new double[100];
//        StringBuilder sb = new StringBuilder();
//        Random rand = new Random();
//        for (int i = 0; i < 100; i++) {
//            int num1 = rand.nextInt(100);
//            double num2 = rand.nextDouble();
//            double num = (double) num1 + num2;
//            input[i] = num;
//            sb.append(num).append(",");
//        }
//        System.out.println(sb.toString());
//        sb.setLength(0);
//        int[] result = test.roundPrices(input);
//        for (int i = 0; i < result.length; i++) {
//            sb.append(result[i]).append(",");
//        }
        double[] arr = new double[]{1.2, 2.5, 3.6, 4.0};
        System.out.println(Arrays.toString(test.roundPrices(arr)));
    }
}
