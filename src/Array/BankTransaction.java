package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class BankTransaction {
    public int bankTransaction(int[] arr) {
        // greedy algorithm: make as much negative transactions as possible
        int net = 0;
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            // case 1: arr[i] >= 0
            // case 2: otherwise
            if (arr[i] >= 0) {
                net += arr[i];
                count++;
            } else {
                net += arr[i];
                minHeap.offer(arr[i]);

                // maintain max negative transaction
                while (!minHeap.isEmpty() && net < 0) {
                    net -= minHeap.poll();
                }
            }
        }
        return count + minHeap.size();
    }

    public static void main(String[] args) {
        BankTransaction test = new BankTransaction();
        int[] arr = new int[]{3, 2, -5, -6, -1, 4};
        System.out.println(test.bankTransaction(arr));
    }
}
