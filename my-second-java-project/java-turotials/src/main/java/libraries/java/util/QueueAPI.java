package libraries.java.util;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author TomAndersen
 */
public class QueueAPI {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Queue<String> queue = linkedList;


        // Inserts the specified element into this queue
        // Queue.offer()
        // Note: Return true if the element was added to this queue, else false
        queue.offer("Jim");
        queue.offer("Alise");
        // Queue.add()
        // Note: Queue.add method may return IllegalStateException, when using a capacity-restricted queue
        queue.add("Tom");
        queue.add("John");

        // Retrieves and removes the head of this queue
        // Queue.poll()
        // Note: returns null if this queue is empty
        System.out.println("queue.poll() = " + queue.poll());
        // Queue.remove()
        // Note: throws an exception if this queue is empty
        System.out.println("queue.remove() = " + queue.remove());


        // Retrieves, but does not remove, the head of this queue
        // Queue.peek()
        // Note: returns null if this queue is empty
        System.out.println("queue.peek() = " + queue.peek());
        // Queue.element()
        // Note: returns null if this queue is empty.
        System.out.println("queue.element() = " + queue.element());

        // Queue.toString
        System.out.println("queue.toString() = " + queue);
    }
}
