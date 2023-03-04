package libraries.java.util;

import java.util.PriorityQueue;

/**
 * @author TomAndersen
 */
public class PriorityQueueAPI {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(22);
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(3);


        // java.util.PriorityQueue order elements in ascending by default
        System.out.println("priorityQueue = " + priorityQueue);
    }
}
