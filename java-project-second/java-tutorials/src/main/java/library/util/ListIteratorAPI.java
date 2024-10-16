package library.util;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author TomAndersen
 * @see java.util.Iterator
 */
public interface ListIteratorAPI {

    /**
     * @see IteratorAPI
     */
    public static void main(String[] args) {
        // ListIterator()
        List<String> staffs = new LinkedList<>(List.of("Tom", "Alise", "John"));
        ListIterator<String> forwardListIter = staffs.listIterator();
        // ListIterator(int index)
        ListIterator<String> backwardListIter = staffs.listIterator(staffs.size());

        // 1. hasPrevious()
        System.out.println("backwardListIter.hasPrevious() = " + backwardListIter.hasPrevious());

        // 2. previous()
        System.out.println("backwardListIter.previous() = " + backwardListIter.previous());

        // hasPrevious+previous, traverse backward
        System.out.println("Traverse backward: ");
        while (backwardListIter.hasPrevious()) {
            System.out.println(backwardListIter.previous());
        }


        while (forwardListIter.hasNext()) {
            // 3. previousIndex()
            System.out.println("forwardListIter.previousIndex() = " + forwardListIter.previousIndex());
            // 4. nextIndex()
            System.out.println("forwardListIter.nextIndex() = " + forwardListIter.nextIndex());
            forwardListIter.next();
        }

        // 5. add()
        // The element is inserted immediately before the element that would be returned by next, if any,
        // and after the element that would be returned by previous, if any
        forwardListIter = staffs.listIterator();
        while (forwardListIter.hasNext()) {
            if ("Tom".equals(forwardListIter.next())) {
                forwardListIter.add("Jim");
            }
        }
        System.out.println(staffs);

        // 6. set()
        // Replaces the last element returned by next or previous with the
        // specified element
        forwardListIter = staffs.listIterator();
        while (forwardListIter.hasNext()) {
            String e = forwardListIter.next();
            if ("Tom".equals(e)) {
                forwardListIter.set("Tom Andersen");
            }
        }
        System.out.println(staffs);

    }
}
