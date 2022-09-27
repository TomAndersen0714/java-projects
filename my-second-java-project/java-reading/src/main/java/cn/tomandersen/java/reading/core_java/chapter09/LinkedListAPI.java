package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListAPI {

    static void LinkedListDemo() {
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

    static void LinkedListAPI() {
        LinkedList<String> staffs = new LinkedList<>();
        staffs.add("Amy");
        staffs.add("Bob");
        staffs.add("Carl");

        Iterator<String> iterator = staffs.iterator();
        String first = iterator.next();
        String second = iterator.next();
        iterator.remove(); // remove 'second' element in the LinkedList
        System.out.println("first: " + first + ", second: " + second);

        // print the all elements in the list
        staffs.forEach(x -> {
            System.out.print(x);
            System.out.print(" ");
        });
        System.out.println();

        // toString()
        System.out.print("toString(): ");
        System.out.println(staffs);

        // contains()
        System.out.print("contains(): ");
        System.out.println(staffs.contains("Amy"));

        // add()
        System.out.print("add(): ");
        List<String> tmp = new LinkedList<>();
        tmp.add("Tom");
        // addAll()
        System.out.print("addAll(): ");
        staffs.addAll(tmp);
        System.out.println(staffs);

        // set
        System.out.print("set(): ");
        staffs.set(0, "Tom");
        System.out.println(staffs);

        // addFirst(), getFirst()
        System.out.print("addFirst(): ");
        staffs.addFirst("Tom");
        System.out.println(staffs);

        // addLast(), getLast()
        System.out.print("addLast(): ");
        staffs.addLast("Andersen");
        System.out.println(staffs);
    }

    public static void main(String[] args) {
//        LinkedListDemo();
        LinkedListAPI();
    }
}
