package Array;

import java.util.PriorityQueue;

public class MinimumHealth {
    public int minimumHealth(int[] initialPlayers, int[] newPlayers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // initialization
        for (int i = 0; i < initialPlayers.length; i++) {
            minHeap.offer(initialPlayers[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // iteration
        int sum = minHeap.peek();
        for (int i : newPlayers) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            sum += minHeap.peek();
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumHealth test = new MinimumHealth();
        int[] initial = new int[]{1, 2};
        int[] newPlayers = new int[]{3, 4};
        System.out.println(test.minimumHealth(initial, newPlayers, 2));
    }
}
