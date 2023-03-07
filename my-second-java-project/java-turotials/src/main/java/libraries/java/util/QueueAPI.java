package libraries.java.util;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author TomAndersen
 * @see java.util.Collection
 */
public interface QueueAPI {

    /**
     * @see libraries.java.util.CollectionAPI
     */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Queue<String> queue = linkedList;


        // offer()
        // Inserts the specified element into this queue
        // Note: Return true if the element was added to this queue, else false
        queue.offer("Jim");
        queue.offer("Alise");
        // add()
        // Note: Queue.add method may return IllegalStateException, when using a capacity-restricted queue
        queue.add("Tom");
        queue.add("John");


        // poll()
        // Retrieves and removes the head of this queue
        // Note: returns null if this queue is empty
        System.out.println("queue.poll() = " + queue.poll());
        // remove()
        // Note: throws an exception if this queue is empty
        System.out.println("queue.remove() = " + queue.remove());


        // peek()
        // Retrieves, but does not remove, the head of this queue
        // Note: returns null if this queue is empty
        System.out.println("queue.peek() = " + queue.peek());
        // element()
        // Note: returns null if this queue is empty.
        System.out.println("queue.element() = " + queue.element());

        // toString
        System.out.println("queue.toString() = " + queue);
    }
}
