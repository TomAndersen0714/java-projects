package library.util;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author TomAndersen
 * @see java.util.Collection
 */
public interface QueueAPI {

    /**
     * @see CollectionAPI
     */
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Queue<String> queue = linkedList;


        // offer()
        // Inserts the specified element into this queue
        // NOTE: Return true if the element was added to this queue, else false
        queue.offer("Jim");
        queue.offer("Alise");
        // add()
        // NOTE: Queue.add method may return IllegalStateException, when using a capacity-restricted queue
        queue.add("Tom");
        queue.add("John");


        // poll()
        // Retrieves and removes the head of this queue
        // NOTE: returns null if this queue is empty
        System.out.println("queue.poll() = " + queue.poll());
        // remove()
        // NOTE: throws an exception if this queue is empty
        System.out.println("queue.remove() = " + queue.remove());


        // peek()
        // Retrieves, but does not remove, the head of this queue
        // NOTE: returns null if this queue is empty
        System.out.println("queue.peek() = " + queue.peek());
        // element()
        // NOTE: returns null if this queue is empty.
        System.out.println("queue.element() = " + queue.element());

        // toString
        System.out.println("queue.toString() = " + queue);
    }
}
