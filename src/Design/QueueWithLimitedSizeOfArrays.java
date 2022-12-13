package Design;

import java.util.ArrayList;
import java.util.List;

public class QueueWithLimitedSizeOfArrays {
    int capacity;
    int size;
    int head;
    int tail;
    List<Object> headList;
    List<Object> tailList;

    public QueueWithLimitedSizeOfArrays(int capacity) {
        this.capacity = capacity;
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
    }

    public void offer(int v) {
        // check
        if (tail == capacity - 1) {
            List<Object> list = new ArrayList<>();
            list.add(v);
            tailList.add(list);
            tailList = (ArrayList<Object>) tailList.get(tail);
            tail = 0;
        } else {
            tailList.add(v);
        }
        tail++;
        size++;
    }

    public Integer poll() {
        // edge case
        if (size == 0) {
            return null;
        }

        // check
        if (head == capacity - 1) {
            headList = (ArrayList<Object>) headList.get(head);
            head = 0;
        }

        int v = (int) headList.get(head);
        head++;
        size--;
        return v;
    }

    public Integer peek() {
        // edge case
        if (size == 0) {
            return null;
        }

        // check
        if (head == capacity - 1) {
            headList = (ArrayList<Object>) headList.get(head);
            head = 0;
        }
        return (int) headList.get(head);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueWithLimitedSizeOfArrays queue = new QueueWithLimitedSizeOfArrays(5);
        System.out.println(queue.poll());//null
        queue.offer(1);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.poll()); //1
        System.out.println(queue.poll()); //1
        System.out.println(queue.poll()); //2
        System.out.println(queue.poll()); //3
        System.out.println(queue.poll()); //4
        queue.offer(7);
        System.out.println("size: " + queue.size()); //size:3
        System.out.println(queue.poll()); //5
        System.out.println(queue.poll()); //6
        System.out.println(queue.poll()); //7
        System.out.println(queue.poll()); //null 

    }
}
