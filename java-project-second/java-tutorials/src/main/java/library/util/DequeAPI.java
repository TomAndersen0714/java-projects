package library.util;

import java.util.*;

/**
 * @author TomAndersen
 * @see java.util.Collection
 * @see java.util.Queue
 * @see java.util.LinkedList
 */
public interface DequeAPI {

    /**
     * @see QueueAPI
     */
    public static void main(String[] args) {
        // construct a deque using a collection
        Deque<String> deque = new LinkedList<>(List.of("1", "2"));

        // NOTE: Deque接口直接继承自Queue, Queue接口相关API可以参考javadoc中的QueueAPI
        //  当前demo仅演示Deque非继承方法

        // toString()
        System.out.println("deque = " + deque);

        // offerFirst()
        deque.offerFirst("A");
        System.out.println("deque.offerFirst = " + deque);
        // offerLast()
        deque.offerLast("B");
        System.out.println("deque.offerLast = " + deque);

        // addFirst()
        deque.addFirst("Tom");
        System.out.println("deque.addFirst = " + deque);
        // addLast()
        deque.addLast("John");
        System.out.println("deque.addLast = " + deque);

        // peekFirst()
        // Retrieves, but does not remove, the first element of this deque,
        // or returns null if this deque is empty
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        // peekLast()
        System.out.println("deque.peekLast() = " + deque.peekLast());

        // pollFirst()
        System.out.println("deque.pollFirst() = " + deque.pollFirst());
        // pollLast()
        System.out.println("deque.pollLast() = " + deque.pollLast());
        System.out.println("deque = " + deque);


        // removeFirst()
        System.out.println("deque.removeFirst() = " + deque.removeFirst());
        // removeLast()
        System.out.println("deque.removeLast() = " + deque.removeLast());
        System.out.println("deque = " + deque);

        // removeFirstOccurrence()
        deque.offer("Tom");
        deque.offer("John");
        deque.offer("Tom");
        deque.offer("Tom");
        deque.offer("John");
        deque.removeFirstOccurrence("Tom");
        // removeLastOccurrence
        deque.removeLastOccurrence("Joh");
        System.out.println("deque = " + deque);
    }
}
