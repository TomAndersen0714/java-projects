package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorAPI {
    /**
     * @see java.util.ListIterator
     */
    public static void main(String[] args) {
        List<String> staffs = new LinkedList<>();
        staffs.add("Bob");
        staffs.add("Alen");
        staffs.add("Amy");

        // ListIterator
        ListIterator<String> listIterator = staffs.listIterator();

        // hasNext(), traverse forward
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
            System.out.print(" ");
        }
        System.out.println();

        // hasPrevious(), traverse reverse
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous());
            System.out.print(" ");
        }
        System.out.println();

        // add()
        System.out.println("next: " + listIterator.next());
        System.out.println("next: " + listIterator.next());
        listIterator.add("Tom");
        staffs.forEach(x -> {
            System.out.print(x);
            System.out.print(" ");
        });
        System.out.println();

        // remove()
        System.out.println("previous: " + listIterator.previous());
        System.out.println("previous: " + listIterator.previous());
        listIterator.remove();

        // set()
        System.out.println("previous: " + listIterator.previous());
        listIterator.set("Jimmy");

        staffs.forEach(x -> {
            System.out.print(x);
            System.out.print(" ");
        });
        System.out.println();

        // ListIterator(int index)
        ListIterator<String> listIterator1 = staffs.listIterator(1);
        while (listIterator1.hasNext()) {
            System.out.print(listIterator1.next());
            System.out.print(" ");
        }
        System.out.println();

        // nextIndex()
        System.out.println("nextIndex: " + listIterator.nextIndex());
        // previousIndex()
        System.out.println("previousIndex: " + listIterator.previousIndex());
    }
}
