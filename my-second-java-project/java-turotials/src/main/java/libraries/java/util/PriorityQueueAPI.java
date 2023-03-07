package libraries.java.util;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author TomAndersen
 * @see libraries.java.util.QueueAPI
 */
public class PriorityQueueAPI {
    public static void main(String[] args) {
        // note: PriorityQueue的API完全继承自其父类, 使用方式全部参考Queue接口的API即可
        // construct a priority queue using a reverse order comparator
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // offer()
        priorityQueue.offer(22);
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(3);


        // java.util.PriorityQueue order elements in ascending by default
        System.out.println("priorityQueue = " + priorityQueue);
    }
}
