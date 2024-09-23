package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Jimmy");
        a.add("Carl");

        LinkedList<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Allen");
        b.add("Doug");
        b.add("Tom");

        // merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next(); // merge from second element
            aIter.add(bIter.next());
        }
        System.out.println(a);

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next(); // skip the one element
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        // bulk operation: remove all elements in b from a
        a.removeAll(b);
        System.out.println(a);

        a.addAll(2, b);
        System.out.println(a);
    }
}
